<template>
	<v-app>
		<default-bar @drawer="drawer = !drawer"></default-bar>
		<default-drawer v-model="drawer"></default-drawer>
		<defalut-view></defalut-view>
	</v-app>
</template>

<script>
import DefaultBar from './AppBar.vue';
import DefaultDrawer from './Drawer.vue';
import DefalutView from './View.vue';
export default {
	name: 'DefalutLayout',
	components: {
		DefaultBar,
		DefaultDrawer,
		DefalutView,
	},
	data: () => ({
		//
		drawer: false,
	}),
	right: null,
};
</script>
s
<style></style>
