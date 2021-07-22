<template>
	<v-container class="primary mt-10" fluid>
		<div id="map" class="map" style="width:100%;height:800px;"></div>

		<v-bottom-navigation color="teal" grow background-color="grey lighten-4">
			<v-btn @click="addMarker">
				<span>백신예방접종</span>

				<v-icon>mdi-needle</v-icon>
			</v-btn>

			<v-btn>
				<span>Favorites</span>

				<v-icon>mdi-heart</v-icon>
			</v-btn>

			<v-btn @click="getLocation">
				<span>내 위치</span>

				<v-icon>mdi-map-marker</v-icon>
			</v-btn>
		</v-bottom-navigation>
	</v-container>
</template>

<script>
import { fetchVaccine } from '@/api/covid';
export default {
	data: () => ({
		values: [],
		lat: [],
		lng: [],
		temp: {
			positions: '',
			latlng: '',
		},
		map: {},
		marker: {},
		location: {
			latitude: '',
			longitude: '',
		},
		myloc: {
			// 37.55499955871682, 126.97050936991083
			lat: 37.55499955871682,
			lon: 126.97050936991083,
		},
	}),
	async mounted() {
		const response = await fetchVaccine();
		console.log(response.data);
		this.values = response.data.data;
		console.log(this.values);
		for (var i = 0; i < this.values.length; i++) {
			this.lat = this.values[i].lat;
			this.lng = this.values[i].lng;
		}
		window.kakao && window.kakao.maps
			? this.initMap(this.location.latitude, this.location.longitude)
			: this.addKakaoMapScript();
	},
	methods: {
		getLocation() {
			navigator.geolocation.getCurrentPosition(this.showPosition);
			this.initMap(this.location.latitude, this.location.longitude);
			// 현재 위치 마커 생성
			this.marker = new kakao.maps.Marker({
				map: this.map, // 마커를 표시할 지도
				// position: positions[i].latlng, // 마커를 표시할 위치
				position: new kakao.maps.LatLng(
					this.location.latitude,
					this.location.longitude,
				),
			});
			this.myloc.lat = this.location.latitude;
			this.myloc.lon = this.location.longitude;
			// this.myloc.lat = this
			this.panTo(this.myloc.lat, this.myloc.lon);
		},
		showPosition(position) {
			this.location.latitude = position.coords.latitude;
			this.location.longitude = position.coords.longitude;
			console.log(this.location);
		},
		addMarker() {
			// 마커 이미지의 이미지 주소입니다
			var imageSrc =
				'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png';
			for (var i = 0; i < this.values.length; i++) {
				// 마커 이미지의 이미지 크기 입니다
				var imageSize = new kakao.maps.Size(24, 35);
				// 마커 이미지를 생성합니다
				var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
				// 마커를 생성합니다
				this.marker = new kakao.maps.Marker({
					map: this.map, // 마커를 표시할 지도
					// position: positions[i].latlng, // 마커를 표시할 위치
					position: new kakao.maps.LatLng(
						//
						this.values[i].lat,
						this.values[i].lng,
					),
					// latlng: new kakao.maps.LatLng(this.values[i].lat, this.values[i].lng),
					// title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
					title: this.values[i].facilityName,
					image: markerImage, // 마커 이미지
				});

				var iwContent = `<div style="padding:5px; width:180px; height:50; ">${this.values[i].facilityName} <br><a href="https://map.kakao.com/link/map/${this.values[i].facilityName},${this.values[i].lat},${this.values[i].lng}"
								 style="color:green" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/${this.values[i].facilityName},${this.values[i].lat},${this.values[i].lng}" style="color:green" target="_blank">길찾기</a></div>`, // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
					iwPosition = new kakao.maps.LatLng(
						this.values[i].lat,
						this.values[i].lng,
					); //인포윈도우 표시 위치입니다

				// 인포윈도우를 생성합니다
				var infowindow = new kakao.maps.InfoWindow({
					position: iwPosition,
					content: iwContent,
				});

				// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다

				if (i == this.values.length - 1) {
					this.panTo(this.myloc.lat, this.myloc.lon);
				} else {
					infowindow.open(this.map, this.marker);
				}
			}
		},
		addKakaoMapScript() {
			const script = document.createElement('script');
			/* global kakao */
			script.onload = () => kakao.maps.load(this.initMap);
			script.src =
				'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=3fc1864d557f3737c9ba3787404db619';
			document.head.appendChild(script);
		},
		// 카카오 맵 호출
		initMap(lat, lon) {
			var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
			var options = {
				//지도를 생성할 때 필요한 기본 옵션
				//37.55499955871682, 126.97050936991083  서울역

				center: new kakao.maps.LatLng(37.55499955871682, 126.97050936991083), //지도의 중심좌표.
				level: 7, //지도의 레벨(확대, 축소 정도)
			};
			console.log(lat, lon);
			var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
			this.map = map;
		},
		panTo(lat, lon) {
			// 이동할 위도 경도 위치를 생성합니다
			var moveLatLon = new kakao.maps.LatLng(
				// 37.55499955871682,
				// 126.97050936991083,
				lat,
				lon,
			);

			// 지도 중심을 부드럽게 이동시킵니다
			// 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
			this.map.panTo(moveLatLon);
		},
	},
};
</script>

<style></style>
