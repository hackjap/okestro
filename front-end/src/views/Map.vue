<template>
	<v-container>
		<v-content>
			<div id="map" class="map" style="width:100%;height:600px;"></div>
		</v-content>
		<v-card class="mt-5">
			<v-btn block @click="addMarker" color="primary">
				우리 동네 백신조회</v-btn
			>
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
			? this.initMap()
			: this.addKakaoMapScript();
	},
	methods: {
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
				var marker = new kakao.maps.Marker({
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
				console.log(marker);

				console.log('RE' + new kakao.maps.LatLng(33.451393, 126.570738));
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
		initMap() {
			var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
			var options = {
				//지도를 생성할 때 필요한 기본 옵션
				center: new kakao.maps.LatLng(37.715133, 126.734086), //지도의 중심좌표.
				level: 10, //지도의 레벨(확대, 축소 정도)
			};

			var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
			this.map = map;
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
