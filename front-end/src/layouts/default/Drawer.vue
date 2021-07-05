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
				<v-list-item-title class="text-h6">
					Application
				</v-list-item-title>
				<v-list-item-subtitle>
					subtext
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
			</v-list-item>
		</v-list>
	</v-navigation-drawer>
</template>

<script>
export default {
	name: 'DefaultDrawer',
	data: () => ({
		gradient: 'rgba(0,0,0,.7), rgba(0,0,0,.7)',
		items: [
			{ title: 'Dashboard', icon: 'mdi-view-dashboard', to: '/' },
			{ title: 'Grid system', icon: 'mdi-image', to: '/gridsystem' },
			{ title: 'Grid List', icon: 'mdi-image', to: '/gridlist' },
			{ title: 'Break Points', icon: 'mdi-image', to: '/breakpoints' },
			{ title: 'Typography', icon: 'mdi-image', to: '/typography' },

			{ title: 'Tables', icon: 'mdi-image', to: '/tables' },
			{ title: 'Buttons', icon: 'mdi-image', to: '/buttons' },
			{ title: 'Icons', icon: 'mdi-image', to: '/icons' },
			{ title: 'Forms', icon: 'mdi-image', to: '/forms' },

			{ title: 'SignIn', icon: 'mdi-login', to: '/signin' },
			{ title: 'SignUp', icon: 'mdi-logout', to: '/signup' },
			{ title: 'ProductList', icon: 'mdi-image', to: '/productlist' },
		],
	}),
};
</script>

<style></style>
