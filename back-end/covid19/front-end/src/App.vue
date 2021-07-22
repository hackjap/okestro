<template>
	<v-app>
		<v-container>
			<div>
				<AppBar @drawer="drawer = !drawer"></AppBar>
				<Drawer v-model="drawer"></Drawer>
			</div>
			<v-content class="mt-10">
				<router-view></router-view>
			</v-content>
		</v-container>
	</v-app>
</template>

<script>
import AppBar from '@/components/common/AppBar.vue';
import Drawer from '@/components/common/Drawer.vue';
export default {
	name: 'App',
	data: () => ({
		drawer: false,
	}),
	components: {
		AppBar,
		Drawer,
	},
};
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap');
/* @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap'); */
* {
	/* font-family: 'Do Hyeon', sans-serif; */
	font-family: 'Jua', sans-serif;

	/* font-family: 'Noto Sans KR', sans-serif; */
}
</style>
