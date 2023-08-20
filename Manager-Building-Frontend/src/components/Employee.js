import React, { useState, useEffect } from "react";
import "../css/building.css";
// import '../css/form.css'
import "../css/search_bar.css";

import Footer from "./Footer";
import Header from "./Header";

import { useLocation } from "react-router";
import { useDispatch, useSelector } from "react-redux";
import {
  getAllCompany,
  createNewCompany,
  updateCompany,
  deleteCompany,
} from "../redux/actions/company";
import {
  createEmployee,
  deleteEmployee,
  getAllEmployeeBy,
  updateEmployee,
} from "../redux/actions/empoyee";

const Employee = () => {
  const [isShow, setIsShow] = useState(false);
  const data = useSelector((state) => state.employee.data);
  const [employees, setEmployees] = useState(data);
  const [isAdd, setIsAdd] = useState(false);
  const location = useLocation();
  const [indexEditEmployee, setIndexEditEmployee] = useState(null);
  const [companyId, setCompanyId] = useState(0);
  const [nameSearch, setNameSearch] = useState("");
  const [isPhone, setIsPhone] = useState(true);

  const [dateOfBirth, setDob] = useState(null);

  const companies = useSelector((state) => state.company.data);

  console.log(companies);

  const dispatch = useDispatch();
  const id = location.pathname.split("/")[3];
  useEffect(() => {
    setCompanyId(Number(id));
    dispatch(getAllEmployeeBy(Number(id)));
    dispatch(getAllCompany());
    return () => {
      console.log(location.pathname);
    };
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [location.pathname]);

  useEffect(() => {
    setEmployees(data);
  }, [data]);

  const onDobChange = (e) => {
    setDob(e.target.value);
    console.log(dateOfBirth);
  };

  const editClick = (index) => {
    setIsShow(true);
    setIsAdd(false);
    setIndexEditEmployee(index);
    document.getElementById("name").value = employees[index].name;
    document.getElementById("dateOfBirth").value = moment(
      employees[index].dateOfBirth,
      "DD-MM-YYYY",
      true
    ).format("YYYY-MM-DD");
    document.getElementById("socialId").value = employees[index].socialId;
    document.getElementById("phone-no").value = employees[index].phoneNo;
    document.querySelector(".form-post").classList.add("active");
  };

  const popUpActive = (mode) => {
    setIsShow(true);
    setIsAdd(true);
    document.querySelector(".form-post").classList.add("active");
    if (mode === "edit") {
      document.querySelector(".dialog__title").textContent =
        "Sửa thông tin nhân viên";
    } else {
      document.querySelector(".dialog__title").textContent =
        "Thêm mới nhân viên";
    }
  };

  const cancelClick = () => {
    setIsShow(false);
    setIsAdd(false);
    document.querySelector(".form-post").classList.remove("active");
  };

  const addOrUpdateItem = () => {
    setIsPhone(true);
    if (isAdd) {
      addItem();
    } else {
      editEmployee();
    }
  };

  const editEmployee = () => {
    const name = document.getElementById("name").value;
    // const dateOfBirth = document.getElementById("dateOfBirth").value;
    const socialId = document.getElementById("socialId").value;
    const phoneNo = document.getElementById("phone-no").value;
    const validate = validatePhone(phoneNo);
    setIsPhone(validate);
    if (!validate) return;

    const data = {
      name: name,
      dateOfBirth: dateOfBirth,
      socialId: socialId,
      phoneNo: phoneNo,
      company: employees[indexEditEmployee].company,
    };

    console.log(employees[indexEditEmployee].id);

    dispatch(updateEmployee(employees[indexEditEmployee].id, data));
    let tmpEmployees = employees;
    tmpEmployees.name = name;
    tmpEmployees.dateOfBirth = dateOfBirth;
    tmpEmployees.socialId = socialId;
    tmpEmployees.phoneNo = phoneNo;
    tmpEmployees.company = employees[indexEditEmployee].company;
    setEmployees(tmpEmployees);
    window.location.reload();
    cancelClick();
  };

  const removeEmployee = (id) => {
    if (id) {
      dispatch(deleteEmployee(id));
      const tmpEmployees = employees.filter((emp) => emp.id != id);
      setEmployees(tmpEmployees);
    }
  };

  const validatePhone = (phoneNumber) => {
    var regPhone = /^\d{10}$/;
    return phoneNumber.match(regPhone);
  };

  const addItem = () => {
    const name = document.getElementById("name").value;
    // const dateOfBirth = document.getElementById("date").value;
    const socialId = document.getElementById("socialId").value;
    const phoneNo = document.getElementById("phone-no").value;
    const validate = validatePhone(phoneNo);
    setIsPhone(validate);
    if (!validate) return;

    const company = companies.find((company) => company.id === Number(id));

    const data = {
      id: 8,
      name: name,
      // dateOfBirth: new Date(dateOfBirth),
      dateOfBirth: new Date(moment(dateOfBirth).format("YYYY-MM-DD")),
      socialId: socialId,
      phoneNo: phoneNo,
      company,
    };

    dispatch(createEmployee(data, companyId));
    window.location.reload();
    cancelClick();
  };

  const searchEmployee = () => {
    if (nameSearch.trim().length == 0) return;
    const tmpEmployees = employees.filter((emp) =>
      emp.name.includes(nameSearch.trim())
    );
    setEmployees(tmpEmployees);
  };

  return (
    <>
      <Header />
      <div style={{ position: "relative", backgroundColor: "white" }}>
        <div style={{ display: isShow ? "block" : "none" }} className="modal">
          <div className="modal_overlay"></div>
          <div className="form-post">
            <div className="form-post__title dialog__title">
              Thêm mới nhân viên
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
                    onChange={(e) => {
                      onDobChange(e);
                    }}
                    type="date"
                    // id="date"
                    id="dateOfBirth"
                    placeholder="date of birth: mm/dd/yyyy"
                  />
                  {/* <span style={{ display: "none" }}>
                    Vui lòng nhập đúng định dạng
                  </span> */}
                </div>
                <div className="form-post__field">
                  <input
                    style={{ width: "100%" }}
                    type="text"
                    id="socialId"
                    placeholder="social id"
                  />
                </div>
                <div className="form-post__field">
                  <input
                    style={{ width: "100%" }}
                    type="text"
                    id="phone-no"
                    placeholder="Phone No"
                  />
                  <span
                    style={{ display: isPhone ? "none" : "" }}
                    className="validate-phone"
                  >
                    Sai định dạng số điện thoại
                  </span>
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
                Danh sách nhân viên
              </div>
              <form action="" class="search-bar">
                <input
                  placeholder="Tìm kiếm nhân viên theo tên"
                  type="search"
                  name="search"
                  pattern=".*\S.*"
                  required
                />
                <button
                  onClick={() => searchEmployee()}
                  class="search-btn"
                  type="submit"
                >
                  <span>Search</span>
                </button>
              </form>
              <div style={{ right: "10px" }} className="admin-post__button">
                <button onClick={() => popUpActive()}>Thêm nhân viên</button>
              </div>
            </div>
            <div className="admin-post__body">
              <table id="admin-post__table" className="table">
                <thead className="thead-dark">
                  <tr style={{ fontSize: "18px" }}>
                    <th>STT</th>
                    <th style={{ width: "200px" }}>Tên</th>
                    <th style={{ width: "200px" }}>Mã nhân viên</th>
                    <th style={{ width: "200px" }}>Số điện thoại</th>
                    <th style={{ width: "200px" }}>Ngày sinh</th>
                    <th style={{ width: "105px" }}>Sửa</th>
                    <th style={{ width: "105px" }}>Xóa</th>
                  </tr>
                </thead>
                <tbody>
                  {employees?.map((item, index) => (
                    <tr key={index}>
                      <td>{index + 1}</td>
                      <td>{item?.name}</td>
                      <td>{item?.socialId}</td>
                      <td>{item?.phoneNo}</td>
                      {/* <td>{item?.dateOfBirth?.split("T")[0]}</td> */}
                      <td>{moment(item?.dateOfBirth).format("DD-MM-YYYY")}</td>
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
                          onClick={() => removeEmployee(item.id)}
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

export default Employee;
