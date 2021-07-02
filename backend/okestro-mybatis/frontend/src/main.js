import Vue from 'vue'
import Vuex from 'vuex';
import App from './App.vue'
import router from './router/index.js';
import vuetify from 'vuetify';
import store from './store/index';


Vue.use(Vuex)
Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router,
  vuetify,
  store,
}).$mount('#app')
