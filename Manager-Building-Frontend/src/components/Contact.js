import React from "react";
import "../css/home.css";
import Header from "./Header";
import Footer1 from "./Footer1";
const Contact = () => {
  return (
    <>
      <Header />
      <div
        style={{
          marginTop: "100px",
          paddingBottom: "80px",
          backgroundColor: "white",
        }}
        className="tb_work_wrapper pb20"
      >
        <div className="container">
          <div className="row">
            <div className="col-md-6 col-lg-6 col-sm-6 col-xs-12">
              <div className="tb_work_txt_wrapper">
                <div className="abt_txt_box">
                  <div className="tb_left_heading_wraper">
                    <h4>Giải pháp quản lý tòa nhà văn phòng</h4>
                    <h3>Hệ thống quản lý tòa nhà version 1.0.1</h3>
                    <h2>
                      <span></span>
                    </h2>
                  </div>
                  <p>
                    Hệ thống cho phép admin có thể quản lý các công ty thuê văn
                    phòng trong tòa nhà cũng như thông tin về các mặt bằng mà
                    công ty đó thuê, quản lý các dịch vụ trong tòa nhà và các
                    nhân viên tòa nhà
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <Footer1 />
    </>
  );
};

export default Contact;
