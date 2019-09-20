package spl.question.bank.database.model;

import java.io.Serializable;

public class TeacherSubject implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher_subject.id
     *
     * @mbg.generated Fri Sep 20 09:20:26 BDT 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher_subject.teacher_id
     *
     * @mbg.generated Fri Sep 20 09:20:26 BDT 2019
     */
    private Integer teacherId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher_subject.subject_id
     *
     * @mbg.generated Fri Sep 20 09:20:26 BDT 2019
     */
    private Integer subjectId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table teacher_subject
     *
     * @mbg.generated Fri Sep 20 09:20:26 BDT 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher_subject.id
     *
     * @return the value of teacher_subject.id
     *
     * @mbg.generated Fri Sep 20 09:20:26 BDT 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher_subject.id
     *
     * @param id the value for teacher_subject.id
     *
     * @mbg.generated Fri Sep 20 09:20:26 BDT 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher_subject.teacher_id
     *
     * @return the value of teacher_subject.teacher_id
     *
     * @mbg.generated Fri Sep 20 09:20:26 BDT 2019
     */
    public Integer getTeacherId() {
        return teacherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher_subject.teacher_id
     *
     * @param teacherId the value for teacher_subject.teacher_id
     *
     * @mbg.generated Fri Sep 20 09:20:26 BDT 2019
     */
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher_subject.subject_id
     *
     * @return the value of teacher_subject.subject_id
     *
     * @mbg.generated Fri Sep 20 09:20:26 BDT 2019
     */
    public Integer getSubjectId() {
        return subjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher_subject.subject_id
     *
     * @param subjectId the value for teacher_subject.subject_id
     *
     * @mbg.generated Fri Sep 20 09:20:26 BDT 2019
     */
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_subject
     *
     * @mbg.generated Fri Sep 20 09:20:26 BDT 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TeacherSubject other = (TeacherSubject) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()))
            && (this.getSubjectId() == null ? other.getSubjectId() == null : this.getSubjectId().equals(other.getSubjectId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_subject
     *
     * @mbg.generated Fri Sep 20 09:20:26 BDT 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        result = prime * result + ((getSubjectId() == null) ? 0 : getSubjectId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_subject
     *
     * @mbg.generated Fri Sep 20 09:20:26 BDT 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", subjectId=").append(subjectId);
        sb.append("]");
        return sb.toString();
    }
}