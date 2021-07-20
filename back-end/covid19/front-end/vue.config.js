// eslint-disable-next-line no-undef
const path = require('path');
// eslint-disable-next-line no-undef
module.exports = {
	devServer: {
		port: 1998,
		overlay: false,
	},

	// 빌드용
	// proxy:{
	//   '/company/*' : {
	//       target : 'http://localhost:9999'
	//   }
	// },

	// eslint-disable-next-line no-undef
	outputDir: path.resolve(__dirname, '../src/main/resources/static'),

	transpileDependencies: ['vuetify'],
};
