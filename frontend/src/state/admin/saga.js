/* eslint-disable no-console */
import { takeEvery, put, call, takeLatest } from 'redux-saga/effects';
import { push } from 'react-router-redux';
import { toastSuccess, toastError } from 'components/Toaster';
import {
  FETCH_ALL_ROLES,
  SAVE_USER,
  SAVE_INSTITUTE,
  FETCH_ALL_INSTITUTE,
  FETCH_INSTITUTE,
  FETCH_ALL_EIIN,
  FETCH_NEW_PASSWORD,
  FETCH_ALL_USERS,
  FETCH_USER,
  SAVE_CLASS,
  FETCH_ALL_CLASS,
  FETCH_CLASS,
  FETCH_ALL_SUBJECT,
  FETCH_SUBJECT,
  SAVE_SUBJECT,
  SAVE_CHAPTER,
  FETCH_ALL_CHAPTER,
  FETCH_CHAPTER,
} from './constants';
import {
  fetchFailure,
  fetchAllRolesSuccess,
  fetchAllInstituteSuccess,
  fetchInstituteSuccess,
  fetchAllInstitute,
  fetchEiinNumbersSuccess,
  fetchNewPasswordSuccess,
  fetchUsersSuccess,
  fetchUserSuccess,
  fetchAllClass,
  fetchClassSuccess,
  fetchAllClassSuccess,
  fetchAllsubjectSuccess,
  fetchSubjectSuccess,
  fetchAllsubject,
  fetchAllChaptersSuccess,
  fetchChapterSuccess,
  fetchAllChapters,
  saveUserSuccess,
  fetchUsers,
  saveUserFilure,
} from './action';

import API from 'utils/api';

export function* fetchAllRoles() {
  try {
    const allRoles = yield call(API.get, 'api/admin/roles');
    yield put(fetchAllRolesSuccess(allRoles));
  } catch (e) {
    console.log('Error in All Roles fetching: ', e);
    yield put(fetchFailure(e));
  }
}

export function* saveUserInfo({ payload: { data } }) {
  if (data.id) {
    try {
      yield call(API.put, 'api/admin/user', data);
      toastSuccess('User updated successfully');
      yield put(saveUserSuccess());
      yield put(fetchUsers());
    } catch (error) {
      console.log('Error: ', error);
      yield put(saveUserFilure());
      toastError(error.response.data.message);
    }
  } else {
    try {
      yield call(API.post, 'api/admin/user', data);
      toastSuccess('User saved successfully');
      yield put(saveUserSuccess());
      yield put(fetchUsers());
      yield put(push(`/manage-user`));
    } catch (error) {
      console.log('Error: ', error);
      yield put(saveUserFilure());
      toastError(error.response.data.message);
    }
  }
}

export function* saveInstituteInfo({ payload: { data } }) {
  if (data.id) {
    try {
      yield call(API.put, `api/admin/institute`, data);
      toastSuccess('Institute info updated successfully');
      yield put(fetchAllInstitute());
    } catch (error) {
      console.log('Error: ', error);
      toastError('Error updating the institute');
    }
  } else {
    try {
      const response = yield call(API.post, 'api/admin/institute', data);
      console.log('Response: ', response);
      yield put(fetchAllInstitute());
    } catch (error) {
      console.log('Error: ', error);
    }
  }
}

export function* fetchInstitutes() {
  try {
    const allInstitute = yield call(API.get, 'api/admin/institutes');
    yield put(fetchAllInstituteSuccess(allInstitute));
  } catch (e) {
    console.log('Error in All Roles fetching: ', e);
    yield put(fetchFailure(e));
  }
}

export function* fetchInstitute({ payload: { id } }) {
  try {
    const instituteDetails = yield call(API.get, `api/admin/institute/${id}`);

    yield put(fetchInstituteSuccess(instituteDetails));
  } catch (e) {
    console.log('Error in All Roles fetching: ', e);
    yield put(fetchFailure(e));
  }
}

export function* fetchEiinNumbers() {
  try {
    const allEiin = yield call(API.get, 'api/admin/institutes/eiin');
    yield put(fetchEiinNumbersSuccess(allEiin));
  } catch (e) {
    console.log('Error in All EIIN fetching: ', e);
    yield put(fetchFailure(e));
  }
}

export function* fetchNewPassword() {
  try {
    const password = yield call(API.get, 'api/admin/generate-password');
    yield put(fetchNewPasswordSuccess(password));
  } catch (e) {
    console.log('Error in All EIIN fetching: ', e);
    yield put(fetchFailure(e));
  }
}

export function* fetchAllUsers() {
  try {
    const users = yield call(API.get, 'api/admin/users');
    yield put(fetchUsersSuccess(users));
  } catch (e) {
    console.log('Error in All EIIN fetching: ', e);
    yield put(fetchFailure(e));
  }
}

export function* fetchUser({ payload: { id } }) {
  try {
    const userDetails = yield call(API.get, `api/admin/user/${id}`);
    yield put(fetchUserSuccess(userDetails));
  } catch (e) {
    console.log('Error in fetching user ', e);
    yield put(fetchFailure(e));
  }
}

export function* saveClass({ payload: { data } }) {
  if (data.id) {
    try {
      yield call(API.put, `api/user/class`, data);
      toastSuccess('Class info updated successfully');
      yield put(fetchAllClass());
    } catch (error) {
      console.log('Error: ', error);
      toastError('Error updating the class');
    }
  } else {
    try {
      yield call(API.post, 'api/user/class', data);
      toastSuccess('New class added successfully');
      yield put(fetchAllClass());
    } catch (error) {
      toastError('Error updating the class');
      console.log('Error: ', error);
    }
  }
}

export function* fetchClasses() {
  try {
    const classes = yield call(API.get, 'api/user/class');
    yield put(fetchAllClassSuccess(classes));
  } catch (error) {
    console.log('Error: ', error);
  }
}

export function* fetchClass({ payload }) {
  const { id } = payload;
  try {
    const classDetail = yield call(
      API.get,
      `api/user/class/${parseInt(id, 10)}`
    );
    yield put(fetchClassSuccess(classDetail));
  } catch (error) {
    console.log('Error: ', error);
  }
}
export function* fetchSubjects() {
  try {
    const subjects = yield call(API.get, 'api/user/subject');
    yield put(fetchAllsubjectSuccess(subjects));
  } catch (error) {
    console.log('Error: ', error);
  }
}

export function* fetchSubject({ payload }) {
  try {
    const { id } = payload;
    const subjectDetails = yield call(API.get, `api/user/subject/${id}`);
    yield put(fetchSubjectSuccess(subjectDetails));
  } catch (error) {
    console.log('Error: ', error);
  }
}

export function* saveSubject({ payload }) {
  const { data } = payload;
  if (data.id) {
    try {
      yield call(API.put, `api/user/subject`, data);
      toastSuccess('Subject info updated successfully');
      yield put(fetchAllsubject());
    } catch (error) {
      console.log('Error: ', error);
      toastError('Error updating the subject');
    }
  } else {
    try {
      yield call(API.post, 'api/user/subject', data);
      toastSuccess('New Subject added successfully');
      yield put(fetchAllsubject());
    } catch (error) {
      console.log('Error: ', error);
    }
  }
}

export function* savechapterInfo({ payload: { data } }) {
  if (data.id) {
    yield call(API.put, 'api/user/chapter', data);
  } else {
    try {
      yield call(API.post, 'api/user/chapter', data);
      toastSuccess('New Chapter added successfully');
      yield put(fetchAllChapters());
    } catch (error) {
      console.log('Error: ', error);
      toastError('Error in saving chapter');
    }
  }
}

export function* fetchAllChapter() {
  try {
    const allChapters = yield call(API.get, 'api/user/chapters');
    yield put(fetchAllChaptersSuccess(allChapters));
  } catch (error) {
    console.log('Error: ', error);
  }
}

export function* fetchChapterById({ payload: { id } }) {
  try {
    const chapterDetail = yield call(API.get, `api/user/chapters/${id}`);
    yield put(fetchChapterSuccess(chapterDetail));
  } catch (error) {
    console.log('Error: ', error);
  }
}

export default function* saga() {
  yield takeEvery(FETCH_ALL_ROLES, fetchAllRoles);
  yield takeLatest(SAVE_USER, saveUserInfo);
  yield takeLatest(SAVE_INSTITUTE, saveInstituteInfo);
  yield takeLatest(FETCH_ALL_INSTITUTE, fetchInstitutes);
  yield takeLatest(FETCH_INSTITUTE, fetchInstitute);
  yield takeLatest(FETCH_ALL_EIIN, fetchEiinNumbers);
  yield takeEvery(FETCH_NEW_PASSWORD, fetchNewPassword);
  yield takeLatest(FETCH_ALL_USERS, fetchAllUsers);
  yield takeEvery(FETCH_USER, fetchUser);
  yield takeLatest(SAVE_CLASS, saveClass);
  yield takeEvery(FETCH_ALL_CLASS, fetchClasses);
  yield takeEvery(FETCH_CLASS, fetchClass);
  yield takeEvery(FETCH_ALL_SUBJECT, fetchSubjects);
  yield takeEvery(FETCH_SUBJECT, fetchSubject);
  yield takeLatest(SAVE_SUBJECT, saveSubject);
  yield takeLatest(SAVE_CHAPTER, savechapterInfo);
  yield takeEvery(FETCH_CHAPTER, fetchChapterById);
  yield takeEvery(FETCH_ALL_CHAPTER, fetchAllChapter);
}
