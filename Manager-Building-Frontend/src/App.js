import * as React from "react";
import { Routes, Route } from "react-router-dom";

import Building from "./components/Building";
import Company from "./components/Company";
import Home from "./components/Home";
import Floor from "./components/Floor";
import MonthlyFeeStatistics from "./components/MonthlyFeeStatistics";
import MonthlyStatistics from "./components/MonthlyStatistics";
import Equipment from "./components/Equipment";
//
import Service from "./components/Service";
import ServiceRegistration_Company from "./components/ServiceRegistration_Company";
import OperatingCosts from "./components/OperatingCosts";
//
import MonthlySalaryEmployee from "./components/MonthlySalaryEmployee";
import Employee from "./components/Employee";
import Work from "./components/Work";
//
import Contact from "./components/Contact";
import Intro from "./components/Intro";
import Login from "./components/Login";
import BuildingEmployee from "./components/BuildingEmployee";
import RentedArea from "./components/RentedArea";
import ContractCompany from "./components/Contract_Companies";
import ServiceRegistration_RegisteredServices from "./components/ServiceRegistration_RegisteredServices";
import ServiceRegistration_Services from "./components/ServiceRegistration_Services";
import StatisticsRentedAreas from "./components/Statistics_RentedAreas";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />}></Route>
      <Route path="/building" element={<Building />} />
      <Route path="/company" element={<Company />}></Route>
      <Route path="/company/view-employees/:id" element={<Employee />}></Route>
      <Route path="/floors" element={<Floor />}></Route>
      <Route path="/rented-areas" element={<RentedArea />}></Route>
      <Route path="/contract-registration" element={<ContractCompany />}></Route>
      <Route
        path="/monthly-fee-statistics"
        element={<MonthlyFeeStatistics />}
      ></Route>
      <Route path="/monthly-statistics" element={<MonthlyStatistics />}></Route>
      <Route path="/monthly-fee-statistics/rented-areas-of-company" element={ <StatisticsRentedAreas/>}></Route>
      <Route path="/equipment" element={<Equipment />}></Route>

      <Route
        path="/service-registration/companies"
        element={<ServiceRegistration_Company />}
      ></Route>
      <Route
        path="service-registration/registered-services"
        element={<ServiceRegistration_RegisteredServices />}
      ></Route>
      <Route
        path="/service-registration/services"
        element={<ServiceRegistration_Services />}
      ></Route>
      <Route path="/service-management" element={<Service />}></Route>
      <Route path="/operating-costs" element={<OperatingCosts />}></Route>

      <Route path="/buildingemployee" element={<BuildingEmployee />}></Route>
      <Route path="/feeemployee" element={<MonthlySalaryEmployee />}></Route>
      <Route path="/work" element={<Work />}></Route>

      <Route path="/contact" element={<Contact />}></Route>
      <Route path="/intro" element={<Intro />}></Route>
      <Route path="/login" element={<Login />} />
    </Routes>
  );
}
export default App;
