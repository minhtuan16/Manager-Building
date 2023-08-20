import React, { useState, useEffect } from "react";
import "../css/building.css";
// import '../css/form.css';
import "../css/search_bar.css";
import Footer from "./Footer";
import Header from "./Header";
// import { Link } from 'react-router-dom';
import { Link } from "react-router-dom";
import { useLocation } from "react-router";
import {
  getAllOperatingCosts,
  deleteOperatingCosts,
  createNewOperatingCosts,
  updateOperatingCosts,
} from "../redux/actions/operating_costs";
import { useDispatch, useSelector } from "react-redux";
import { duration } from "moment";

const OperatingCosts = () => {
  const token = localStorage.getItem("token");
  const [isShow, setIsShow] = useState(false);
  const data = useSelector((state) => state.operatingCosts.data);
  const [operatingCosts, setOperatingCosts] = useState(data);
  const [isAdd, setIsAdd] = useState(false);
  const location = useLocation();
  console.log(data);
  const [indexEditOperatingCosts, setIndexEditOperatingCosts] = useState(null);
  const [nameSearch, setNameSearch] = useState("");

  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(getAllOperatingCosts());
    return () => {
      console.log(location.pathname);
    };
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [location.pathname]);

  useEffect(() => {
    setOperatingCosts(data);
  }, [data]);

  const editClick = (index) => {
    setIsShow(true);
    setIsAdd(false);
    setIndexEditOperatingCosts(index);
    document.getElementById("name").value = operatingCosts[index].name;
    document.getElementById("price").value = operatingCosts[index].price;
    document.getElementById("payment").value = operatingCosts[index].payment;
    document.querySelector(".form-post").classList.add("active");
  };

  const popUpActive = (mode) => {
    setIsShow(true);
    setIsAdd(true);
    document.querySelector(".form-post").classList.add("active");
    if (mode === "edit") {
      document.querySelector(".dialog__title").textContent =
        "Sửa thông tin chi phí vận hành";
    } else {
      document.querySelector(".dialog__title").textContent =
        "Thêm mới chi phí vận hành";
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
      editOperatingCosts();
    }
  };

  const editOperatingCosts = () => {
    const name = document.getElementById("name").value;
    const price = document.getElementById("price").value;
    const payment = document.getElementById("payment").value;

    const data = {
      name: name,
      price: price,
      payment: payment,
    };
    dispatch(
      updateOperatingCosts(operatingCosts[indexEditOperatingCosts].id, data)
    );
    let tmpOperatingCosts = operatingCosts;
    tmpOperatingCosts[indexEditOperatingCosts].name = name;
    tmpOperatingCosts[indexEditOperatingCosts].price = price;
    tmpOperatingCosts[indexEditOperatingCosts].payment = payment;
    setOperatingCosts(tmpOperatingCosts);
    cancelClick();
  };

  const removeOperatingCosts = (id) => {
    if (id) {
      dispatch(deleteOperatingCosts(id));
      const tmpOperatingCosts = operatingCosts.filter((com) => com.id !== id);
      setOperatingCosts(tmpOperatingCosts);
    }
  };

  const addItem = () => {
    const name = document.getElementById("name").value;
    const price = document.getElementById("price").value;
    const payment = document.getElementById("payment").value;

    const data = {
      name: name,
      price: price,
      payment: payment,
    };

    dispatch(createNewOperatingCosts(data));
    window.location.reload();

    cancelClick();
  };

  const searchOperatingCosts = () => {
    if (nameSearch.trim().length == 0) {
      setOperatingCosts(data);
      return;
    }
    const tmpOperatingCosts = operatingCosts.filter((emp) =>
      emp.name.includes(nameSearch.trim())
    );
    setOperatingCosts(tmpOperatingCosts);
  };

  return (
    <>
      <Header />
      <div style={{ backgroundColor: "white" }}>
        <div style={{ display: isShow ? "block" : "none" }} className="modal">
          <div className="modal_overlay"></div>
          <div className="form-post">
            <div className="form-post__title dialog__title">
              Thêm mới chi phí vận hành
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
                    id="price"
                    placeholder="Giá tiền"
                  />
                </div>
                <div className="form-post__field">
                  <input
                    style={{ width: "100%" }}
                    type="text"
                    id="payment"
                    placeholder="Hạn trả"
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
                Danh sách chi phí vận hành
              </div>
              <form action="" class="search-bar" style={{ marginLeft: "10px" }}>
                <input type="search" name="search" pattern=".*\S.*" required />
                <button
                  onClick={() => searchOperatingCosts()}
                  class="search-btn"
                  type="submit"
                >
                  <span>Search</span>
                </button>
              </form>
              <div style={{ right: "10px" }} className="admin-post__button">
                <button onClick={() => popUpActive()}>
                  Thêm chi phí vận hành
                </button>
              </div>
            </div>
            <div className="admin-post__body">
              <table id="admin-post__table" className="table">
                <thead className="thead-dark">
                  <tr style={{ fontSize: "18px" }}>
                    <th>STT</th>
                    <th style={{ width: "200px" }}>Tên</th>
                    <th style={{ width: "200px" }}>Giá tiền</th>
                    <th style={{ width: "200px" }}>Hạn trả</th>
                    <th style={{ width: "105px" }}>Sửa</th>
                    <th style={{ width: "105px" }}>Xóa</th>
                  </tr>
                </thead>
                <tbody>
                  {operatingCosts?.map((item, index) => (
                    <tr key={index}>
                      <td>{index + 1}</td>
                      <td>{item?.name}</td>
                      <td>
                        {new Intl.NumberFormat("vi-VN", {
                          style: "currency",
                          currency: "VND",
                        }).format(item?.price)}
                      </td>
                      <td>{item?.payment}</td>

                      {/* <td>
                        <Link
                          to={{
                            pathname: "/rented-areas",
                            search: `?operatingCostsId=` + item?.id,
                          }}
                        >
                          <button className="post-edit-item-btn">
                            <i className="bx bxs-pencil"></i>
                            Xem
                          </button>
                        </Link>
                      </td> */}
                      <td>
                        <button
                          className="post-edit-item-btn"
                          onClick={() => editClick(item)}
                        >
                          <i className="bx bxs-pencil"></i>
                          Sửa
                        </button>
                      </td>
                      <td>
                        <button
                          className="post-delete-btn"
                          onClick={() => removeOperatingCosts(item.id)}
                        >
                          <i className="bx bx-trash"></i>
                          Xóa
                        </button>
                      </td>
                    </tr>
                  ))}
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

export default OperatingCosts;
