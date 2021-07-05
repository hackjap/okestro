import Vue from 'vue';
import Vuex from 'vuex';


Vue.use(Vuex)

export default new Vuex.Store({
    
  state: {
        username :  '',
        token : ''
  },
  mutations: {
  

  },
  actions: {
 
  },
  getters: {
    isLogin(){
        return this.state.token != '';
    }
    
  }
})