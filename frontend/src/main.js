import Vue from 'vue'
import App from './App.vue'
import router from './router/index.js';
import vuetify from 'vuetify';

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router,
  vuetify,
}).$mount('#app')
