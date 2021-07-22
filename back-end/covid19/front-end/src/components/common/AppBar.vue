<template>
	<v-app-bar app color="primary" dark>
		<v-app-bar-nav-icon @click="$emit('drawer')"></v-app-bar-nav-icon>
		<v-toolbar-title>{{ $route.name }}</v-toolbar-title>
		<v-spacer>
			<!-- 1 -->
			<template v-if="isUserLogin">
				<v-row justify="end" class="pa-5">
					<v-btn class="mr-3" @click="logoutUser"> 로그아웃</v-btn>
				</v-row>
			</template>
			<!-- 2 -->
			<template v-else>
				<v-row justify="end" class="pa-5">
					<v-btn class="mr-3" to="/login"> 로그인</v-btn>
					<v-btn class="mr-3" to="/signup"> 회원가입</v-btn>
				</v-row>

				<!-- <router-link to="/login">로그인</router-link>

				<router-link to="/signup">회원가입</router-link> -->
			</template>
		</v-spacer>
	</v-app-bar>
</template>

<script>
export default {
	name: 'DefaultBar',

	computed: {
		isUserLogin() {
			return this.$store.getters.isLogin;
		},
	},
	methods: {
		logoutUser() {
			this.$store.commit('clearName');
			this.$router.push('/login');
		},
	},
};
</script>

<style></style>
