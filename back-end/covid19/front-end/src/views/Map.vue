<template>
	<v-container>
		<v-card class="mt-5">
			<div id="map" class="map" style="width:100%;height:600px;"></div>
			<v-card class="mt-5"> </v-card>
			<v-btn block @click="addMarker" color="primary">
				백신예방접종 장소 조회</v-btn
			>
			<v-btn block @click="getLocation" color="indigo"> 내 위치 조회 </v-btn>
		</v-card>
	</v-container>
</template>

<script>
import { fetchVaccine } from '@/api/index';

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
			? this.initMap(37.715133, 126.734086)
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
						this.values[i].lat,
						this.values[i].lng,
					),
					// latlng: new kakao.maps.LatLng(this.values[i].lat, this.values[i].lng),

					// title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
					title: this.values[i].facilityName,
					image: markerImage, // 마커 이미지
				});
				console.log(this.marker);

				console.log('RE' + new kakao.maps.LatLng(33.451393, 126.570738));

				// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
				kakao.maps.event.addListener(this.marker, 'click', function() {
					// overlay.setMap(this.map);
					// var a = this.values[i].facilityName;
					console.log('click1' + this.values);
				});
			}

			// this.clickMarker();
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
				center: new kakao.maps.LatLng(lat, lon), //지도의 중심좌표.
				level: 7, //지도의 레벨(확대, 축소 정도)
			};

			var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
			this.map = map;
		},

		clickMarker() {
			// 커스텀 오버레이에 표시할 컨텐츠 입니다
			// 커스텀 오버레이는 아래와 같이 사용자가 자유롭게 컨텐츠를 구성하고 이벤트를 제어할 수 있기 때문에
			// // 별도의 이벤트 메소드를 제공하지 않습니다
			// var content =
			// 	'<div class="wrap">' +
			// 	'    <div class="info">' +
			// 	'        <div class="title">' +
			// 	'            카카오 스페이스닷원' +
			// 	'            <div class="close" onclick="closeOverlay()" title="닫기"></div>' +
			// 	'        </div>' +
			// 	'        <div class="body">' +
			// 	'            <div class="img">' +
			// 	'                <img src="https://cfile181.uf.daum.net/image/250649365602043421936D" width="73" height="70">' +
			// 	'           </div>' +
			// 	'            <div class="desc">' +
			// 	'                <div class="ellipsis">제주특별자치도 제주시 첨단로 242</div>' +
			// 	'                <div class="jibun ellipsis">(우) 63309 (지번) 영평동 2181</div>' +
			// 	'                <div><a href="https://www.kakaocorp.com/main" target="_blank" class="link">홈페이지</a></div>' +
			// 	'            </div>' +
			// 	'        </div>' +
			// 	'    </div>' +
			// 	'</div>';
			// var overlay = new kakao.maps.CustomOverlay({
			// 	content: content,
			// 	map: this.map,
			// 	position: this.marker.getPosition(),
			// });
			// // 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
			// kakao.maps.event.addListener(this.marker, 'click', function(mouseEvent) {
			// 	overlay.setMap(this.map);
			// 	var a = mouseEvent.latlng;
			// 	console.log('click' + a);
			// });
		},
	},
};
</script>

<style>
.map {
	width: 100%;
	height: 400px;
}
</style>
