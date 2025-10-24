import { axiosGet } from '../../utils/dataFetch.js';

export const getList = async() => {
    const url = "/support/list";
    const jsonData = await axiosGet(url);
    console.log("getList :: jsonData => ", jsonData);
    return jsonData;
}