import Vue from 'vue';
import App from './App.vue';
import router from './router';
import vuetify from './plugins/vuetify';
import axios from 'axios';
import store from '@/store/index';

Vue.config.productionTip = false;
Vue.prototype.$http = axios; // axios http 전역변수로 사용

new Vue({
	vuetify,
	render: h => h(App),
	router,
	store,
}).$mount('#app');
