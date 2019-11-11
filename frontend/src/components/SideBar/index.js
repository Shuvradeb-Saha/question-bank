import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import PropTypes from 'prop-types';
import { Roles } from 'containers/App/constants';
import { AccessDenied } from 'components';

const AdminSidebar = () => (
  <ul className="list-group sticky-top sticky-offset">
    <li className="list-group-item bg-info sidebar-separator-title d-flex align-items-center">
      <b>
        <small>Admin</small>
      </b>
    </li>

    <Link
      to="/"
      className="list-group-item list-group-item-action bg-dark text-white"
    >
      <div className="d-flex w-100 justify-content-start align-items-center">
        <span className="fa fa-home fa-fw mr-3"></span>
        <span className="menu-collapsed">Home</span>
      </div>
    </Link>
    <Link
      to="/profile"
      className="list-group-item list-group-item-action bg-dark text-white"
    >
      <div className="d-flex w-100 justify-content-start align-items-center">
        <span className="fa fa-user fa-fw mr-3"></span>
        <span className="menu-collapsed">Profile</span>
      </div>
    </Link>
    <Link
      to="/manage-user"
      className="list-group-item list-group-item-action bg-dark text-white"
    >
      <div className="d-flex w-100 justify-content-start align-items-center">
        <span className="fa fa-users fa-fw mr-3"></span>
        <span className="menu-collapsed">Manage User</span>
      </div>
    </Link>
    <Link
      to="/manage-institute"
      className="list-group-item list-group-item-action bg-dark text-white"
    >
      <div className="d-flex w-100 justify-content-start align-items-center">
        <span className="fa fa-university fa-fw mr-3"></span>
        <span className="menu-collapsed">Manage Institute</span>
      </div>
    </Link>
    <Link
      to="/manage-class"
      className="list-group-item list-group-item-action bg-dark text-white"
    >
      <div className="d-flex w-100 justify-content-start align-items-center">
        <span className="fa fa-address-card fa-fw mr-3"></span>
        <span className="menu-collapsed">Manage Class</span>
      </div>
    </Link>
    <Link
      to="/manage-subject"
      className="list-group-item list-group-item-action bg-dark text-white"
    >
      <div className="d-flex w-100 justify-content-start align-items-center">
        <span className="fa fa-book fa-fw mr-3"></span>
        <span className="menu-collapsed">Manage Subject</span>
      </div>
    </Link>
    <Link
      to="/manage-chapter"
      className="list-group-item list-group-item-action bg-dark text-white"
    >
      <div className="d-flex w-100 justify-content-start align-items-center">
        <span className="fa fa-object-group fa-fw mr-3"></span>
        <span className="menu-collapsed">Manage Chapter</span>
      </div>
    </Link>
  </ul>
);

const HeadMasterSidebar = ({ roles }) => {
  return (
    <ul className="list-group sticky-top sticky-offset">
      <li className="list-group-item bg-info sidebar-separator-title d-flex align-items-center">
        <b>
          <small>Headmaster</small>
        </b>
      </li>

      {renderTeacherOptions()}
      <a
        href="#teacher-list"
        data-toggle="collapse"
        aria-expanded="false"
        className="bg-dark list-group-item list-group-item-action flex-column align-items-start"
      >
        <div className="d-flex w-100 justify-content-start align-items-center">
          <span className="fa fa-tasks fa-fw mr-3"></span>
          <span className="menu-collapsed">Manage Teacher</span>
          <span className="submenu-icon ml-auto"></span>
        </div>
      </a>

      <div id="teacher-list" className="collapse sidebar-submenu">
        <Link
          to="/teacher/pending"
          className="list-group-item list-group-item-action bg-dark text-white"
        >
          <span className="menu-collapsed">Pending list</span>
        </Link>
        <Link
          to="/teacher/approved"
          className="list-group-item list-group-item-action bg-dark text-white"
        >
          <span className="menu-collapsed">Approved list</span>
        </Link>
      </div>
      {roles.includes(Roles.MODERATOR) && renderModerationOption()}
    </ul>
  );
};

const renderTeacherOptions = () => (
  <span>
    <Link
      to="/"
      className="list-group-item list-group-item-action bg-dark text-white"
    >
      <div className="d-flex w-100 justify-content-start align-items-center">
        <span className="fa fa-home fa-fw mr-3"></span>
        <span className="menu-collapsed">Home</span>
      </div>
    </Link>
    <Link
      to="/profile"
      className="list-group-item list-group-item-action bg-dark text-white"
    >
      <div className="d-flex w-100 justify-content-start align-items-center">
        <span className="fa fa-user fa-fw mr-3"></span>
        <span className="menu-collapsed">Profile</span>
      </div>
    </Link>
    <Link
      to="/question/create"
      className="list-group-item list-group-item-action bg-dark text-white"
    >
      <div className="d-flex w-100 justify-content-start align-items-center">
        <span className="fa fa-plus-square fa-fw mr-3"></span>
        <span className="menu-collapsed">Create Question</span>
      </div>
    </Link>
    <a
      href="#question-status"
      data-toggle="collapse"
      aria-expanded="false"
      className="bg-dark list-group-item list-group-item-action flex-column align-items-start"
    >
      <div className="d-flex w-100 justify-content-start align-items-center">
        <span className="fa fa-eye fa-fw mr-3"></span>
        <span className="menu-collapsed">Question Status</span>
        <span className="submenu-icon ml-auto"></span>
      </div>
    </a>
    <div id="question-status" className="collapse sidebar-submenu">
      <Link
        to="/question/pending"
        className="list-group-item list-group-item-action bg-dark text-white"
      >
        <span className="menu-collapsed">Pending list</span>
      </Link>
      <Link
        to="/question/approved"
        className="list-group-item list-group-item-action bg-dark text-white"
      >
        <span className="menu-collapsed">Approved list</span>
      </Link>
      <Link
        to="/question/rejected"
        className="list-group-item list-group-item-action bg-dark text-white"
      >
        <span className="menu-collapsed">Rejected list</span>
      </Link>
    </div>
  </span>
);

const TeacherSidebar = () => (
  <ul className="list-group sticky-top sticky-offset">
    <li className="list-group-item bg-info sidebar-separator-title d-flex align-items-center">
      <b>
        <small>Teacher</small>
      </b>
    </li>
    {renderTeacherOptions()}
  </ul>
);

const ModeratorSidebar = () => (
  <ul className="list-group sticky-top sticky-offset">
    <li className="list-group-item bg-info sidebar-separator-title d-flex align-items-center">
      <b>
        <small>Moderator</small>
      </b>
    </li>
    {renderTeacherOptions()}
    {renderModerationOption()}
  </ul>
);

const renderModerationOption = () => (
  <span>
    <a
      href="#moderate"
      data-toggle="collapse"
      aria-expanded="false"
      className="bg-dark list-group-item list-group-item-action flex-column align-items-start"
    >
      <div className="d-flex w-100 justify-content-start align-items-center">
        <span className="fa fa-tasks mr-3"></span>

        <span className="menu-collapsed">Moderate Question</span>
        <span className="submenu-icon ml-auto"></span>
      </div>
    </a>

    <div id="moderate" className="collapse sidebar-submenu">
      <a
        href="#cq"
        data-toggle="collapse"
        aria-expanded="false"
        className="bg-dark list-group-item list-group-item-action flex-column align-items-start"
      >
        <div className="d-flex w-100 justify-content-start align-items-center">
          <span className="menu-collapsed">Creative Question</span>
          <span className="submenu-icon ml-auto"></span>
        </div>
      </a>
      <div id="cq" className="collapse sidebar-submenu">
        <Link
          to="/moderate/question/pending"
          className="list-group-item list-group-item-action bg-dark text-white"
        >
          <span className="menu-collapsed">Pending CQ</span>
        </Link>
        <Link
          to="/moderate/question/approved"
          className="list-group-item list-group-item-action bg-dark text-white"
        >
          <span className="menu-collapsed">Approved CQ</span>
        </Link>
        <Link
          to="/moderate/question/rejected"
          className="list-group-item list-group-item-action bg-dark text-white"
        >
          <span className="menu-collapsed">Rejected CQ</span>
        </Link>
      </div>
      <a
        href="#mcq"
        data-toggle="collapse"
        aria-expanded="false"
        className="bg-dark list-group-item list-group-item-action flex-column align-items-start"
      >
        <div className="d-flex w-100 justify-content-start align-items-center">
          <span className="menu-collapsed">Multiple Choice</span>
          <span className="submenu-icon ml-auto"></span>
        </div>
      </a>

      <div id="mcq" className="collapse sidebar-submenu">
        <Link
          to="/moderate/mcq/pending"
          className="list-group-item list-group-item-action bg-dark text-white"
        >
          <span className="menu-collapsed">Pending MCQ</span>
        </Link>
        <Link
          to="/moderate/mcq/approved"
          className="list-group-item list-group-item-action bg-dark text-white"
        >
          <span className="menu-collapsed">Approved MCQ</span>
        </Link>
        <Link
          to="/moderate/mcq/rejected"
          className="list-group-item list-group-item-action bg-dark text-white"
        >
          <span className="menu-collapsed">Rejected MCQ</span>
        </Link>
      </div>
    </div>
  </span>
);

class SideBar extends Component {
  static propTypes = {
    roles: PropTypes.any,
  };

  componentDidUpdate() {}

  render() {
    const { roles } = this.props;
    return (
      <div
        id="sidebar-container"
        className="sidebar-expanded d-none d-md-block col-2 "
      >
        {roles.includes(Roles.ADMIN) ? (
          <AdminSidebar />
        ) : roles.includes(Roles.HEADMASTER) ? (
          <HeadMasterSidebar roles={roles} />
        ) : roles.includes(Roles.MODERATOR) ? (
          <ModeratorSidebar />
        ) : roles.includes(Roles.TEACHER) ? (
          <TeacherSidebar />
        ) : (
          <AccessDenied />
        )}
      </div>
    );
  }
}

export default SideBar;
