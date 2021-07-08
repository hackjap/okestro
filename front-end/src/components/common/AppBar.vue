<template>
	<v-app-bar app color="primary" dark>
		<v-app-bar-nav-icon @click="$emit('drawer')"></v-app-bar-nav-icon>
		<v-toolbar-title>{{ $route.name }}</v-toolbar-title>
		<v-spacer></v-spacer>
	</v-app-bar>
</template>

<script>
export default {
	name: 'DefaultBar',
};
</script>

<style></style>
