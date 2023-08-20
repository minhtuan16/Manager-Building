import React, { useState, useEffect } from "react";
import "../css/building.css";
// import '../css/form.css'
import "../css/search_bar.css";
import Footer from "./Footer";
import Header from "./Header";
import { Link } from "react-router-dom";
import { useLocation } from "react-router";
import {
  getAllEquipment,
  deleteEquipment,
  createNewEquipment,
  updateEquipment,
} from "../redux/actions/equipment";
import { useDispatch, useSelector } from "react-redux";

const Equipment = () => {
  const token = localStorage.getItem("token");
  const [isShow, setIsShow] = useState(false);
  const data = useSelector((state) => state.equipment.data);
  const [equipment, setEquipment] = useState();
  const [isAdd, setIsAdd] = useState(false);
  const location = useLocation();
  const [indexEditEquipment, setIndexEditEquipment] = useState(null);
  const [nameSearch, setNameSearch] = useState("");

  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(getAllEquipment());
    return () => {
      console.log(location.pathname);
    };
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [location.pathname]);

  useEffect(() => {
    setEquipment(data);
  }, [data]);

  const editClick = (index) => {
    setIsShow(true);
    setIsAdd(false);
    setIndexEditEquipment(index);
    document.getElementById("name").value = equipment[index].name;
    document.getElementById("quantity").value = equipment[index].quantity;
    document.getElementById("location").value = equipment[index].location;
    document.querySelector(".form-post").classList.add("active");
  };

  const popUpActive = (mode) => {
    setIsShow(true);
    setIsAdd(true);
    document.querySelector(".form-post").classList.add("active");
    if (mode === "edit") {
      document.querySelector(".dialog__title").textContent =
        "Sửa thông tin trang thiết bị";
    } else {
      document.querySelector(".dialog__title").textContent =
        "Thêm mới trang thiết bị";
    }
  };

  const cancelClick = () => {
    setIsShow(false);
    setIsAdd(false);
    document.querySelector(".form-post").classList.remove("active");
  };

  const addOrUpdateItem = () => {
    if (isAdd) {
      addItem();
    } else {
      editEquipment();
    }
  };

  const editEquipment = () => {
    const name = document.getElementById("name").value;
    const quantity = document.getElementById("quantity").value;
    const location = document.getElementById("location").value;
    const data = {
      name: name,
      quantity: quantity,
      location: location,
    };
    dispatch(updateEquipment(equipment[indexEditEquipment].id, data));
    let tmpEquipment = equipment;
    tmpEquipment[indexEditEquipment].name = name;
    tmpEquipment[indexEditEquipment].quantity = quantity;
    tmpEquipment[indexEditEquipment].location = location;
    setEquipment(tmpEquipment);
    cancelClick();
  };

  const removeEquipment = (id) => {
    if (id) {
      dispatch(deleteEquipment(id));
      const tmpEquipment = equipment.filter((com) => com.id !== id);
      setEquipment(tmpEquipment);
    }
  };

  const addItem = () => {
    const name = document.getElementById("name").value;
    const quantity = document.getElementById("quantity").value;
    const location = document.getElementById("location").value;
    const data = {
      name: name,
      quantity: quantity,
      location: location,
    };

    dispatch(createNewEquipment(data));
    window.location.reload();

    cancelClick();
  };

  const searchEquipment = () => {
    if (nameSearch.trim().length) {
      setEquipment(data);
      return;
    }
    const tmpEquipment = equipment.filter((emp) =>
      emp.name.includes(nameSearch.trim())
    );
    setEquipment(tmpEquipment);
  };

  return (
    <>
      <Header />
      <div style={{ backgroundColor: "white" }}>
        <div>
          {isShow && <div className="modal_overlay"></div>}
          <div className="form-post">
            <div className="form-post__title dialog__title">
              Thêm mới trang thiết bị
            </div>
            <div className="form-post__content">
              <div className="form-post__wrapper">
                <div className="form-post__field">
                  <input
                    style={{ width: "100%" }}
                    type="text"
                    id="name"
                    placeholder="Name"
                  />
                </div>
                <div className="form-post__field">
                  <input
                    style={{ width: "100%" }}
                    type="text"
                    id="quantity"
                    placeholder="Số lượng"
                  />
                </div>
                <div className="form-post__field">
                  <input
                    style={{ width: "100%" }}
                    type="text"
                    id="location"
                    placeholder="Vị trí"
                  />
                </div>

                <div className="form-post__control">
                  <button onClick={() => cancelClick()} className="cancel-btn">
                    Hủy
                  </button>
                  <button
                    className="add-section-btn"
                    onClick={() => addOrUpdateItem()}
                  >
                    <i className="bx bx-save"></i>
                    Lưu
                  </button>
                </div>
              </div>
            </div>
          </div>
          <div
            style={{ maxWidth: "1100px", minHeight: "100vh" }}
            className="admin-post__container"
          >
            <div className="admin-post__wrapper">
              <div className="admin-post__head">
                <div
                  style={{ fontSize: "20px", marginLeft: "-20px" }}
                  className="admin-post__title"
                >
                  Danh sách trang thiết bị
                </div>
                <form
                  action=""
                  class="search-bar"
                  style={{ marginLeft: "4px" }}
                >
                  <input
                    type="search"
                    name="search"
                    pattern=".*\S.*"
                    required
                  />
                  <button
                    onClick={() => searchEquipment()}
                    class="search-btn"
                    type="submit"
                  >
                    <span>Search</span>
                  </button>
                </form>
                <div style={{ right: "10px" }} className="admin-post__button">
                  <button onClick={() => popUpActive()}>
                    Thêm trang thiết bị
                  </button>
                </div>
              </div>
              <div className="admin-post__body">
                <table id="admin-post__table" className="table">
                  <thead className="thead-dark">
                    <tr style={{ fontSize: "18px" }}>
                      <th>STT</th>
                      <th style={{ width: "200px" }}>Tên</th>
                      <th style={{ width: "200px" }}>Số lượng</th>
                      <th style={{ width: "200px" }}>Vị trí</th>
                      <th style={{ width: "105px" }}>Sửa</th>
                      <th style={{ width: "105px" }}>Xóa</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>Quạt trần</td>
                      <td>120</td>
                      <td>Khu A</td>
                      <td>
                        <button className="post-edit-item-btn">
                          <i className="bx bxs-pencil"></i>
                          Sửa
                        </button>
                      </td>
                      <td>
                        <button className="post-delete-btn">
                          <i className="bx bx-trash"></i>
                          Xóa
                        </button>
                      </td>
                    </tr>
                    <tr>
                      <td>2</td>
                      <td>Bóng đèn</td>
                      <td>150</td>
                      <td>Khu A</td>
                      <td>
                        <button className="post-edit-item-btn">
                          <i className="bx bxs-pencil"></i>
                          Sửa
                        </button>
                      </td>
                      <td>
                        <button className="post-delete-btn">
                          <i className="bx bx-trash"></i>
                          Xóa
                        </button>
                      </td>
                    </tr>
                    <tr>
                      <td>3</td>
                      <td>Điều hòa âm tường</td>
                      <td>60</td>
                      <td>Khu A</td>
                      <td>
                        <button className="post-edit-item-btn">
                          <i className="bx bxs-pencil"></i>
                          Sửa
                        </button>
                      </td>
                      <td>
                        <button className="post-delete-btn">
                          <i className="bx bx-trash"></i>
                          Xóa
                        </button>
                      </td>
                    </tr>
                    {/* {equipment?.map((item, index) => (
                      <tr key={index}>
                        <td>{index + 1}</td>
                        <td>{item?.name}</td>
                        <td>{item?.quantity}</td>
                        <td>{item?.location}</td>
                        <td>
                          <button
                            onClick={() => editClick(index)}
                            className="post-edit-item-btn"
                          >
                            <i className="bx bxs-pencil"></i>
                            Sửa
                          </button>
                        </td>
                        <td>
                          <button
                            className="post-delete-btn"
                            onClick={() => removeEquipment(item.id)}
                          >
                            <i className="bx bx-trash"></i>
                            Xóa
                          </button>
                        </td>
                      </tr>
                    ))} */}
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
};

export default Equipment;
