const path = require('path')
module.exports = {
    devServer: {
        port: 8081,
    },
    // 빌드용 
    // proxy:{
    //   '/company/*' : {
    //       target : 'http://localhost:9999'
    //   }
    // },
    
    outputDir : path.resolve(__dirname, '../src/main/resources/static')
}