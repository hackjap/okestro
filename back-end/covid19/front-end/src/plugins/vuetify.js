import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';
import colors from 'vuetify/lib/util/colors';

Vue.use(Vuetify);

export default new Vuetify({
	breakpoint: {
		mobileBreakpoint: 'xs',
	},

	theme: {
		themes: {
			light: {
				primary: '#4CAF50',
				secondary: colors.blue,
			},
		},
	},
});