import axios from "axios";
import { ERROR } from "../constants/base";
import { DELETE, GET_ALL, GET_ONE, POST, UPDATE } from "../constants/building";

export const getAllBuilding = () => async (dispatch) => {
  try {
    const res = await axios({
      method: "GET",
      baseURL: process.env.REACT_APP_URL_API,
      url: "building",
      headers: {
        Authorization: "Bearer " + localStorage.getItem("token"),
        "Content-Type": "application/json",
      },
    });
    if (res.status === 200) {
      dispatch({
        type: GET_ALL,
        data: res.data,
      });
    } else {
      dispatch({
        type: ERROR,
        data: null,
      });
    }
  } catch (error) {
    dispatch({
      type: ERROR,
      data: null,
    });
  }
};

export const getBuildingById = (id) => async (dispatch) => {
  try {
    const res = await axios({
      method: "GET",
      baseURL: process.env.REACT_APP_URL_API,
      url: `building/${id}`,
      headers: {
        Authorization: "Bearer " + localStorage.getItem("token"),
        "Content-Type": "application/json",
      },
    });
    if (res.status == 200) {
      dispatch({
        type: GET_ONE,
        data: res.data,
      });
    } else {
      dispatch({
        type: ERROR,
        data: null,
      });
    }
  } catch (error) {
    dispatch({
      type: ERROR,
      data: null,
    });
  }
};

export const createNewBuilding = (data) => async (dispatch) => {
  try {
    const res = await axios({
      method: "POST",
      baseURL: process.env.REACT_APP_URL_API,
      url: `building`,
      data: data,
      headers: {
        Authorization: "Bearer " + localStorage.getItem("token"),
        "Content-Type": "application/json",
      },
    });
    if (res.status == 200) {
      dispatch({
        type: POST,
        data: res.data,
      });
    } else {
      dispatch({
        type: ERROR,
        data: null,
      });
    }
  } catch (error) {
    dispatch({
      type: ERROR,
      data: null,
    });
  }
};

export const updateBuilding = (id, data) => async (dispatch) => {
  try {
    const res = await axios({
      method: "PUT",
      baseURL: process.env.REACT_APP_URL_API,
      url: `building/${id}`,
      data: data,
      headers: {
        Authorization: "Bearer " + localStorage.getItem("token"),
        "Content-Type": "application/json",
      },
    });
    if (res.status == 200) {
      dispatch({
        type: UPDATE,
        data: res.data,
      });
    } else {
      dispatch({
        type: ERROR,
        data: null,
      });
    }
  } catch (error) {
    dispatch({
      type: ERROR,
      data: null,
    });
  }
};

export const deleteBuilding = (id) => async (dispatch) => {
  try {
    const res = await axios({
      method: "DELETE",
      baseURL: process.env.REACT_APP_URL_API,
      url: `building/${id}`,
      headers: {
        Authorization: "Bearer " + localStorage.getItem("token"),
        "Content-Type": "application/json",
      },
    });
    if (res.status === 200) {
      dispatch({
        type: DELETE,
        data: res.data,
      });
    } else {
      dispatch({
        type: ERROR,
        data: null,
      });
    }
  } catch (error) {
    dispatch({
      type: ERROR,
      data: null,
    });
  }
};
