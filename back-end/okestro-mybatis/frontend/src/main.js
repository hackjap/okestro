import Vue from 'vue'
import Vuex from 'vuex';
import App from './App.vue'
import router from './router/index.js';
import store from './store/index';
import 'vuetify/dist/vuetify.min.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'
import vuetify from './plugins/vuetify'


Vue.use(Vuex)
Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router,
  vuetify,
  store
}).$mount('#app')
