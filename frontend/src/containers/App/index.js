import React, { Component } from 'react';
import { Route, Switch, withRouter } from 'react-router-dom';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { createStructuredSelector } from 'reselect';
import Loader from 'react-loader-spinner';
import 'react-toastify/dist/ReactToastify.css';

import { userIsAuthenticated } from 'utils/reduxAuth';
import HomePage from '../Home';
import Login from '../Login';
import { Toaster } from 'components';
import { fetchCurrentUserProfile } from 'state/login/action';
import {
  makeAuthenticated,
  makeLoginErrorCode,
  makeInProgress,
} from 'state/login/selectors';
import { OtpSend } from 'containers';

const NOT_FOUND = () => <h1>Not Found</h1>;

const PRE_LOGIN_LOADER = () => (
  <div className="container-fluid h-100 mt-5">
    <div className="row align-items-center h-100">
      <div className="col mx-auto">
        <div className="jumbotron">
          <div className="jumbotron d-flex align-items-center flex-column justify-content-center h-100 text-white">
            <Loader type="Puff" color="#00BFFF" height="200" width="200" />
          </div>
        </div>
      </div>
    </div>
  </div>
);
/* 
const NO_Server = () => (
  <div className="container-fluid h-100 mt-5">
    <div className="row align-items-center h-100">
      <div className="col mx-auto">
        <div className="jumbotron">
          <div className="jumbotron d-flex align-items-center flex-column justify-content-center h-100 text-white">
            <h1>Cannot connect to the server</h1>
          </div>
        </div>
      </div>
    </div>
  </div>
); */
class App extends Component {
  static propTypes = {
    location: PropTypes.object.isRequired,
    authenticated: PropTypes.bool.isRequired,
    fetchCurrentUserProfile: PropTypes.func.isRequired,
    inProgress: PropTypes.bool.isRequired,
    errorCode: PropTypes.any,
  };

  static defaultProps = {
    authenticated: false,
    inProgress: false,
  };

  componentDidMount = () => {
    const { authenticated, fetchCurrentUserProfile } = this.props;

    if (!authenticated) {
      fetchCurrentUserProfile();
    }
  };

  componentDidUpdate(prevProps, prevState) {
    if (this.locationHasBeenUpdated(prevProps.location, this.props.location)) {
      window.scrollTo(0, 0);
    }
  }

  locationHasBeenUpdated = (prevLocation, newLocation) => {
    if (prevLocation && newLocation) {
      /* From observation, it seems that the key always changes even if user loads the same url again.*/
      if (prevLocation.key !== newLocation.key) {
        return true;
      }
    }
    return false;
  };

  render() {
    return (
      <div>
        <Switch>
          <Route
            path="/login"
            component={this.props.inProgress ? PRE_LOGIN_LOADER : Login}
          />
          <Route path="/forget/password" component={OtpSend} />
          <Route path="/" component={userIsAuthenticated(HomePage)} />
          <Route path="" component={NOT_FOUND} />
        </Switch>
        <Toaster />
      </div>
    );
  }
}

const mapStateToProps = createStructuredSelector({
  authenticated: makeAuthenticated(),
  inProgress: makeInProgress(),
  errorCode: makeLoginErrorCode(),
});

const mapDispatchToProps = dispatch => ({
  fetchCurrentUserProfile: () => dispatch(fetchCurrentUserProfile()),
});

const withConnect = connect(
  mapStateToProps,
  mapDispatchToProps
);

export default withRouter(withConnect(App));
