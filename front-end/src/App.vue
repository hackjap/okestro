<template>
	<v-app>
		<v-container>
			<div>
				<AppBar @drawer="drawer = !drawer"></AppBar>
				<Drawer v-model="drawer"></Drawer>
			</div>
			<v-content>
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
