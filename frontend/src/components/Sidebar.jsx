import React ,{useState} from "react";

import { Link } from "react-router-dom";

import {
  ProSidebar,
  Menu,
  MenuItem,
  SidebarHeader,
  SidebarFooter,
  SidebarContent,
} from "react-pro-sidebar";

import {
  FiHome,
  FiLogOut,
  FiArrowLeftCircle,
  FiArrowRightCircle,
  FiUsers,
} from "react-icons/fi";
import { RiPencilLine } from "react-icons/ri";
import { BiCog } from "react-icons/bi";
import { HiPencilAlt, HiOutlineCheck } from "react-icons/hi";

import "react-pro-sidebar/dist/css/styles.css";
import "./SideBar.css";

export default function Sidebar() {
    const [menuCollapse, setMenuCollapse] = useState(false);
    const [active, setActive] = useState(false);
    const menuIconClick = () => {
      menuCollapse ? setMenuCollapse(false) : setMenuCollapse(true);
    };
    const handleMenuActive = () => {
      active ? setActive(true) : setActive(false);
    };

    return (
      <>
        <div id="header">
          <ProSidebar collapsed={menuCollapse}>
            <SidebarHeader>
              <div className="logotext">
                {/* small and big change using menucollapse state */}
                {/* <p>{menuCollapse ? "Logo" : "Big Logo"}</p> */}
                <img
                  src="https://svn.apache.org/repos/asf/lucene.net/branches/3.0.3/branding/logo/lucene-net-icon-512x256.png"
                  alt=""
                />
              </div>
            </SidebarHeader>
            <SidebarContent>
              <Menu iconShape="square">
                <MenuItem icon={<FiHome />}>
                  <Link to="/">DashBoard</Link>
                </MenuItem>
                <MenuItem icon={<FiUsers />}>
                  <Link to="/employees">Empleado</Link>
                </MenuItem>
                <MenuItem icon={<HiPencilAlt />}>
                  <Link to="/departments">Departamento</Link>
                </MenuItem>
                <MenuItem icon={<HiOutlineCheck />}>
                  <Link to="/equipments">Equipamiento</Link>
                </MenuItem>
                {/* <MenuItem icon={<BiCog />}>Settings</MenuItem> */}
              </Menu>
            </SidebarContent>
            <SidebarFooter>
              <Menu iconShape="square">
                <MenuItem icon={<FiLogOut />}>Salir</MenuItem>
              </Menu>
            </SidebarFooter>
          </ProSidebar>
        </div>
      </>
    );
  };

