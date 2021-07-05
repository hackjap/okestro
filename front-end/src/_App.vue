<template>
	<v-app>
		<v-app-bar v-if="$vuetify.breakpoint.xsOnly" app />
		<v-navigation-drawer app />
		<v-main>
			<v-container fuild>
				컨텐츠 영역
			</v-container>
		</v-main>
		<v-footer app />
	</v-app>
</template>

<script>
export default {};
</script>

<style></style>
