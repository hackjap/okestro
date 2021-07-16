<template>
	<v-navigation-drawer
		v-bind="$attrs"
		dark
		app
		:src="require('@/assets/sidebar.jpg')"
	>
		<template v-slot:img="props">
			<v-img :gradient="gradient" v-bind="props" />
		</template>
		<v-list-item>
			<v-list-item-content>
				<v-list-item-title class="text-h6 ">
					COVID-VUE
				</v-list-item-title>
				<v-list-item-subtitle class="mt-1">
					장성필님 환영합니다.
				</v-list-item-subtitle>
			</v-list-item-content>
		</v-list-item>

		<v-divider></v-divider>

		<v-list dense nav>
			<v-list-item
				v-for="item in items"
				:key="item.title"
				link
				:to="item.to"
				active-class="primary"
				class="py-1"
			>
				<v-list-item-icon>
					<v-icon>{{ item.icon }}</v-icon>
				</v-list-item-icon>

				<v-list-item-content>
					<v-list-item-title>{{ item.title }}</v-list-item-title>
				</v-list-item-content>
				<!-- <template v-if="isAuth && ">
				</template> -->
			</v-list-item>
		</v-list>
	</v-navigation-drawer>
</template>

<script>
import store from '../../store/index';
export default {
	name: 'DefaultDrawer',
	methods: {
		test() {
			return true;
		},
	},

	computed: {
		isAuth() {
			return !store.getters.isAdmin;
		},
	},
	data: () => ({
		gradient: 'rgba(0,0,0,.7), rgba(0,0,0,.7)',
		items: [
			// { title: '오늘의 확진자', icon: 'mdi-view-dashboard', to: '/' },
			// { title: 'Grid system', icon: 'mdi-image', to: '/gridsystem' },
			// { title: 'Grid List', icon: 'mdi-image', to: '/gridlist' },
			// { title: 'Break Points', icon: 'mdi-image', to: '/breakpoints' },
			// { title: 'Typography', icon: 'mdi-image', to: '/typography' },

			// { title: 'Tables', icon: 'mdi-image', to: '/tables' },
			// { title: 'Buttons', icon: 'mdi-image', to: '/buttons' },
			// { title: 'Icons', icon: 'mdi-image', to: '/icons' },
			// { title: 'Forms', icon: 'mdi-image', to: '/forms' },

			{
				title: '코로나 확진자',
				icon: 'mdi-chart-line',
				to: '/chart',
			},
			{ title: '백신예방접종센터', icon: 'mdi-map', to: '/map' },

			{ title: '백신접종신청', icon: 'mdi-map', to: '/vaccine' },

			{
				title: '관리자페이지',
				icon: 'mdi-emoticon-devil-outline',
				to: '/adminregister',
			},
		],
	}),
};
</script>

<style></style>
