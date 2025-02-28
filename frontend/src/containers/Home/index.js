import React, { Component } from 'react';
import PropTypes from 'prop-types';
import ImmutablePropTypes from 'react-immutable-proptypes';
import { connect } from 'react-redux';
import { createStructuredSelector } from 'reselect';
import { withRouter } from 'react-router-dom';
import dummy from 'static/dummy.jpeg';
import Header from 'components/Header';
import { SideBar, AdminContent, MixContent, AccessDenied } from 'components';
import { logout } from 'state/login/action';
import {
  fetchAllClass,
  fetchAllChapters,
  fetchAllSubject,
} from 'state/login/action';
import { makeUserName, makeRoles, makePropic } from 'state/login/selectors';
import { Roles } from 'containers/App/constants';

class HomePage extends Component {
  static propTypes = {
    username: PropTypes.string.isRequired,
    roles: ImmutablePropTypes.list.isRequired,
    logout: PropTypes.func.isRequired,
    fetchAllClass: PropTypes.func.isRequired,
    fetchAllSubject: PropTypes.func.isRequired,
    fetchAllChapter: PropTypes.func.isRequired,
    profilePic: PropTypes.string,
  };

  static defaultProps = {
    username: 'User',
    roles: [],
  };

  componentDidMount() {
    this.props.fetchAllClass();
    this.props.fetchAllSubject();
    this.props.fetchAllChapter();
  }

  onLogout = () => {
    const { logout } = this.props;
    localStorage.clear();
    logout();
  };

  render() {
    const { roles, username, profilePic } = this.props;
    const img =
      profilePic === '' ? dummy : `data:image/jpeg;base64, ${profilePic}`;

    return (
      <div>
        <Header username={username} onLogout={this.onLogout} profilePic={img} />
        <div className="row mt-4" id="body-row">
          <SideBar roles={roles.toJS()} />
          <div className="col py-3">
            {roles.toJS().includes(Roles.ADMIN) ? (
              <AdminContent />
            ) : roles.toJS().includes(Roles.HEADMASTER) ? (
              <MixContent />
            ) : roles.toJS().includes(Roles.HEADMASTER) ||
              roles.toJS().includes(Roles.TEACHER) ? (
              <MixContent />
            ) : (
              <AccessDenied />
            )}
          </div>
        </div>
      </div>
    );
  }
}

const mapStateToProps = createStructuredSelector({
  username: makeUserName(),
  roles: makeRoles(),
  profilePic: makePropic(),
});
const mapDispatchToProps = dispatch => ({
  logout: () => dispatch(logout()),
  fetchAllClass: () => dispatch(fetchAllClass()),
  fetchAllSubject: () => dispatch(fetchAllSubject()),
  fetchAllChapter: () => dispatch(fetchAllChapters()),
});

const withConnect = connect(
  mapStateToProps,
  mapDispatchToProps
);

export default withRouter(withConnect(HomePage));
