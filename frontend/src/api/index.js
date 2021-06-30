import axios from 'axios'


const instance = axios.create({
    baseURL: 'http://localhost:9999/',
});


async function fetchCompany() {
    const response = instance.get('company');
    return response;
}

// 회사등록 
async function registerCompany(companyData){
    const response = instance.post('company',companyData);
    return response;
}




export {

    fetchCompany,registerCompany
}