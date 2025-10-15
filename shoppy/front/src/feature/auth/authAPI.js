import { login, logout } from '../../feature/auth/authSlice.js';
import { validateFormCheck } from '../../utils/validate.js';
import { axiosPost } from '../../utils/dataFetch.js';


export const getLogin = (formData, param) => async(dispatch) => {

    if(validateFormCheck(param)) {
        /**
        * springboot 연동 부분
        */
        const url = "http://localhost:8080/member/login";
        const result = await axiosPost(url, formData);
        console.log('result-->', result);

//        if("test" === formData.id && "1234" === formData.pwd) {
          if(result) {
            dispatch(login({"userId":formData.id}));   
            return result;
        } 
    }
    return false;
}

export const getLogout = () => async(dispatch) => {
    dispatch(logout());
    return true;
}
