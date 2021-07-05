import Vue from 'vue';
import VueRouter from 'vue-router';
import Dashboard from '../views/Dashboard';
import GridSystem from '../views/GridSystem';
import GridList from '../views/GridListPage';
import BreakPoints from '../views/Breakpoints';
import Typography from '../views/Typography';
import Tables from '../views/Tables';
import Forms from '../views/Forms';
import Buttons from '../views/Buttons';
import Icons from '../views/Icons';
import SignUp from '../views/authentication/SignUp';
import SignIn from '../views/authentication/SignIn';
import ProductList from '../views/page/ProductList';
import DefaultLayout from '../layouts/default/Index';
import PageLayout from '../layouts/page/Index';
import AuthenticationLayout from '../layouts/authentication/Index';

Vue.use(VueRouter);

const routes = [
	{
		path: '/',

		component: DefaultLayout,
		children: [
			{
				path: '/',
				name: 'Dashboard',
				component: Dashboard,
			},
			{
				path: '/gridsystem',
				name: 'GridSystem',
				component: GridSystem,
			},
			{
				path: '/gridlist',
				name: 'GridList',
				component: GridList,
			},
			{
				path: '/breakpoints',
				name: 'BreakPoints',
				component: BreakPoints,
			},
			{
				path: '/typography',
				name: 'Typography',
				component: Typography,
			},
			{
				path: '/tables',
				name: 'Tables',
				component: Tables,
			},
			{
				path: '/forms',
				name: 'Forms',
				component: Forms,
			},
			{
				path: '/buttons',
				name: 'Buttons',
				component: Buttons,
			},
			{
				path: '/icons',
				name: 'Icons',
				component: Icons,
			},
		],
	},
	{
		path: '/authentication',
		component: AuthenticationLayout,
		children: [
			{ path: '/signup', name: 'SignUp', component: SignUp },
			{
				path: '/signin',
				name: 'SignIn',
				component: SignIn,
			},
		],
	},
	{
		path: '/page',
		component: PageLayout,
		children: [
			{ path: '/productlist', name: 'Product', component: ProductList },
		],
	},
	{
		path: '/default',
		component: DefaultLayout,
		children: [],
	},
];

const router = new VueRouter({
	mode: 'history',
	routes,
});

export default router;
