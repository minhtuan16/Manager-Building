import React, { useState, useEffect } from "react";
import "../css/building.css";
// import '../css/form.css';
import "../css/search_bar.css";
import Footer from "./Footer";
import Header from "./Header";
import { useLocation } from "react-router";
import { useDispatch, useSelector } from "react-redux";
import {
  getAllBuilding,
  createNewBuilding,
  updateBuilding,
  deleteBuilding,
} from "../redux/actions/building";
import { Link } from "react-router-dom";

const Building = () => {
  const token = localStorage.getItem("token");
  const [isShow, setIsShow] = useState(false);
  const data = useSelector((state) => state.building.data);
  const [buildings, setBuilding] = useState();
  const [isAdd, setIsAdd] = useState(false);
  const location = useLocation();
  const [indexEditBuilding, setIndexEditBuilding] = useState(null);
  const [nameSearch, setNameSearch] = useState("");

  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(getAllBuilding());
    return () => {
      console.log(location.pathname);
    };
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [location.pathname]);

  useEffect(() => {
    setBuilding(data);
  }, [data]);

  const editClick = (index) => {
    setIsShow(true);
    setIsAdd(false);
    setIndexEditBuilding(index);
    document.getElementById("name").value = buildings[index].name;
    document.getElementById("floors").value = buildings[index].floors;
    document.getElementById("location").value = buildings[index].location;
    document.querySelector(".form-post").classList.add("active");
  };

  const popUpActive = (mode) => {
    setIsShow(true);
    setIsAdd(true);
    document.querySelector(".form-post").classList.add("active");
    if (mode === "edit") {
      document.querySelector(".dialog__title").textContent =
        "Sửa thông tin tòa nhà";
    } else {
      document.querySelector(".dialog__title").textContent = "Thêm mới tòa nhà";
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
      editBuilding();
    }
  };

  const editBuilding = () => {
    const name = document.getElementById("name").value;
    const floors = document.getElementById("floors").value;
    const location = document.getElementById("location").value;
    const data = {
      name: name,
      floors: floors,
      location: location,
    };
    dispatch(updateBuilding(buildings[indexEditBuilding].id, data));
    let tmpBuildings = buildings;
    tmpBuildings[indexEditBuilding].name = name;
    tmpBuildings[indexEditBuilding].floors = floors;
    tmpBuildings[indexEditBuilding].location = location;
    setBuilding(tmpBuildings);
    cancelClick();
  };

  const removeBuilding = (id) => {
    if (id) {
      dispatch(deleteBuilding(id));
      const tmpBuildings = buildings.filter((com) => com.id !== id);
      setBuilding(tmpBuildings);
    }
  };

  const addItem = () => {
    const name = document.getElementById("name").value;
    const floors = document.getElementById("floors").value;
    const location = document.getElementById("location").value;
    const data = {
      name: name,
      floors: floors,
      location: location,
    };

    dispatch(createNewBuilding(data));
    window.location.reload();

    cancelClick();
  };

  const searchBuilding = () => {
    if (!nameSearch.trim().length) {
      setBuilding(data);
      return;
    }
    const tmpBuildings = buildings.filter((emp) =>
      emp.name.includes(nameSearch.trim())
    );
    setBuilding(tmpBuildings);
  };

  const linkAction = (id, status) => {
    const navLink = document.querySelectorAll(".nav__link");
    navLink.forEach((n) => n.classList.remove("active"));
    if (id) {
      const _this = document.getElementById(id);
      _this.classList.add("active");
    }

    if (status === true) {
      const toggle = document.getElementById("header-toggle");
      const nav = document.getElementById("nav-menu");
      if (nav && toggle) {
        toggle.classList.remove("bx-x");
        nav.classList.remove("show");
      }
    }
  };

  return (
    <>
      <Header />
      <div style={{ position: "relative", backgroundColor: "white" }}>
        <div style={{ display: isShow ? "block" : "none" }} className="modal">
          <div className="modal_overlay"></div>
          <div className="form-post">
            <div className="form-post__title dialog__title">
              Thêm mới tòa nhà
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
                    id="floors"
                    placeholder="Số tầng"
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
                Danh sách tòa nhà
              </div>
              <form action="" class="search-bar">
                <input
                  type="search"
                  name="search"
                  pattern=".*\S.*"
                  required
                  onChange={(e) => setNameSearch(e.target.value)}
                />
                <button
                  onClick={() => searchBuilding()}
                  class="search-btn"
                  type="submit"
                >
                  <span>Search</span>
                </button>
              </form>
              <div style={{ right: "10px" }} className="admin-post__button">
                <button onClick={() => popUpActive()}>Thêm tòa nhà</button>
              </div>
            </div>
            <div className="admin-post__body">
              <table id="admin-post__table" className="table">
                <thead className="thead-dark">
                  <tr style={{ fontSize: "18px" }}>
                    <th>STT</th>
                    <th style={{ width: "200px" }}>Tên</th>
                    <th style={{ width: "200px" }}>Số tầng</th>
                    <th style={{ width: "200px" }}>Vị trí</th>
                    <th style={{ width: "105px" }}>Sửa</th>
                    <th style={{ width: "105px" }}>Xóa</th>
                    <th style={{ width: "105px" }}>Xem</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>1</td>
                    <td>Tòa nhà A1</td>
                    <td>9</td>
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
                    <td>
                      <button className="post-view-btn">
                        <i className="bx bx-trash"></i>
                        <Link
                          className="btn-view"
                          to="/company"
                          onClick={() => linkAction(null, true)}
                        >
                          Xem
                        </Link>
                      </button>
                    </td>
                  </tr>
                  <tr>
                    <td>2</td>
                    <td>Tòa nhà B1</td>
                    <td>12</td>
                    <td>Khu B</td>
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
                    <td>
                      <button className="post-view-btn">
                        <i className="bx bx-trash"></i>
                        <Link
                          className="btn-view"
                          to="/company"
                          onClick={() => linkAction(null, true)}
                        >
                          Xem
                        </Link>
                      </button>
                    </td>
                  </tr>
                  <tr>
                    <td>3</td>
                    <td>Tòa nhà C1</td>
                    <td>16</td>
                    <td>Khu C</td>
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
                    <td>
                      <button className="post-view-btn">
                        <i className="bx bx-trash"></i>
                        <Link
                          className="btn-view"
                          to="/company"
                          onClick={() => linkAction(null, true)}
                        >
                          Xem
                        </Link>
                      </button>
                    </td>
                  </tr>

                  {/* {buildings?.map((item, index) => (
                    <tr key={index}>
                      <td>{index + 1}</td>
                      <td>{item?.name}</td>
                      <td>{item?.floors}</td>
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
                          onClick={() => removeBuilding(item.id)}
                        >
                          <i className="bx bx-trash"></i>
                          Xóa
                        </button>
                      </td>
                      <td>
                        <button className="post-view-btn">
                          <i className="bx bx-trash"></i>
                          <Link
                            className="btn-view"
                            to="/company"
                            onClick={() => linkAction(null, true)}
                          >
                            Xem
                          </Link>
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
      <Footer />
    </>
  );
};

export default Building;
