import React from "react";
import "../css/footer1.css";

function Footer() {
  return (
    <div className="footer-content" style={{ height: "300px" }}>
      <div className="container-fluid">
        <div class="row">
          <div class="col-sm-2 footer-content__logo">
            <h3 className="footer-content__title footer-logo">
              BUILDINGMANAGER
            </h3>
            <p className="copyright">
              <small className="footer-content__color">NHÓM 6 @2023</small>
            </p>
          </div>
          <div class="footer-item__container col-sm-2">
            <h3 className="footer-content__title"> Customer</h3>
            <ul class="list-unstyled links">
              <li>
                <a className="footer-content__color" href="/">
                  Home
                </a>
              </li>
              <li>
                <a className="footer-content__color" href="/">
                  About
                </a>
              </li>
              <li>
                <a className="footer-content__color" href="/">
                  FAQ
                </a>
              </li>
              <li>
                <a className="footer-content__color" href="/">
                  Get Started
                </a>
              </li>
              <li>
                <a className="footer-content__color" href="/">
                  Videos
                </a>
              </li>
            </ul>
          </div>
          <div class="col-sm-2 ">
            <h3 className="footer-content__title"> Company</h3>
            <ul class="list-unstyled links">
              <li>
                <a className="footer-content__color" href="/">
                  Home
                </a>
              </li>
              <li>
                <a className="footer-content__color" href="/">
                  About
                </a>
              </li>
              <li>
                <a className="footer-content__color" href="/">
                  FAQ
                </a>
              </li>
              <li>
                <a className="footer-content__color" href="/">
                  Get Started
                </a>
              </li>
            </ul>
          </div>

          <div class="col-sm-2">
            <h3 className="footer-content__title"> Furture Information</h3>
            <ul class="list-unstyled links">
              <li>
                <a className="footer-content__color" href="/">
                  Home
                </a>
              </li>
              <li>
                <a className="footer-content__color" href="/">
                  About
                </a>
              </li>
              <li>
                <a className="footer-content__color" href="/">
                  FAQ
                </a>
              </li>
              <li>
                <a className="footer-content__color" href="/">
                  Get Started
                </a>
              </li>
            </ul>
          </div>

          <div class="col-md-3 footer-item__container">
            <h3 className="footer-content__title"> Follow us</h3>
            <ul class="list-unstyled list-inline social text-center">
              <li class="list-inline-item">
                <a
                  className="footer-content__color footer-content__icons"
                  href="/"
                >
                  <i class="fa fa-facebook"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a
                  className="footer-content__color footer-content__icons"
                  href="/"
                >
                  <i class="fa fa-twitter"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a
                  className="footer-content__color footer-content__icons"
                  href="/"
                >
                  <i class="fa fa-instagram"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a
                  className="footer-content__color footer-content__icons"
                  href="/"
                >
                  <i class="fa fa-google-plus"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a
                  className="footer-content__color footer-content__icons"
                  href="/"
                  target="_blank"
                >
                  <i class="fa fa-envelope"></i>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Footer;
