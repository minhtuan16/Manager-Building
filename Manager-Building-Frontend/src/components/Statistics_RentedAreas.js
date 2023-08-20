import React from "react";
import { useState } from "react";
import { useLocation } from "react-router";
import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import moment from "moment";
import { getAllRentedAreasOfCompany } from "../redux/actions/statistics_rented_areas";
import { getCompanyById } from "../redux/actions/company";

import Header from "./Header";
import Footer from "./Footer";
function StatisticsRentedAreas() {
  const [isShow, setIsShow] = useState(false);
  const location = useLocation();
  const dispatch = useDispatch();
  const rentedAreasFromReducer = useSelector(
    (state) => state.statisticsRentedAreas.data
  );
  const company = useSelector((state) => state.company.company);
  const search = useLocation().search;
  const companyId = new URLSearchParams(search).get("companyId");

  useEffect(() => {
    dispatch(getAllRentedAreasOfCompany(companyId));
    dispatch(getCompanyById(companyId));
    return () => {};
  }, [location.pathname]);

  return (
    <>
      <Header />
      <div style={{ position: "relative", backgroundColor: "white" }}>
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
                Danh sách các mặt bằng của công ty{" "}
                <span style={{ color: "red", fontSize: "30px" }}>
                  {company?.name}
                </span>{" "}
                thuê trong tòa nhà
              </div>
            </div>
            <div className="admin-post__body">
              <table id="admin-post__table" className="table">
                <thead className="thead-dark">
                  <tr style={{ fontSize: "18px" }}>
                    <th>STT</th>
                    <th style={{ width: "100px" }}>Tầng</th>
                    <th style={{ width: "100px" }}>Vị trí</th>
                    <th style={{ width: "200px" }}>Diện tích thuê(m2)</th>
                    <th style={{ width: "200px" }}>Ngày bắt đầu thuê</th>
                    <th style={{ width: "200px" }}>Ngày kết thúc</th>
                    <th style={{ width: "200px" }}>
                      Giá tiền thuê /m2 (1 tháng)
                    </th>
                    <th style={{ width: "200px" }}>Số tiền trả theo tháng</th>
                    <th style={{ width: "200px" }}>Số tiền trả cả năm</th>
                  </tr>
                </thead>
                <tbody>
                  {rentedAreasFromReducer?.map((item, index) => (
                    <tr key={index}>
                      <td>{index + 1}</td>
                      <td>{item?.floor?.name}</td>
                      <td>{item?.position}</td>
                      <td>{item?.rentedArea}</td>
                      <td>{moment(item?.rentedDate).format("DD-MM-YYYY")}</td>
                      <td>{moment(item?.expiredDate).format("DD-MM-YYYY")}</td>
                      <td>
                        {new Intl.NumberFormat("vi-VN", {
                          style: "currency",
                          currency: "VND",
                        }).format(item?.floor?.pricePerM2)}
                      </td>
                      {/* <td>{item?.floor?.pricePerM2}</td> */}
                      <td>
                        {new Intl.NumberFormat("vi-VN", {
                          style: "currency",
                          currency: "VND",
                        }).format(item?.currentPrice)}
                      </td>
                      {/* <td>{item?.currentPrice}</td> */}
                      <td>
                        {new Intl.NumberFormat("vi-VN", {
                          style: "currency",
                          currency: "VND",
                        }).format(item?.currentPrice * 12)}
                      </td>
                      {/* <td>{item?.currentPrice * 12}</td> */}
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
}

export default StatisticsRentedAreas;
