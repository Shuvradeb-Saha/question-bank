package spl.question.bank.database.client;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import spl.question.bank.database.MapperMarker;
import spl.question.bank.database.model.User;
import spl.question.bank.database.model.UserExample;

public interface UserMapper extends MapperMarker {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Jun 20 19:57:23 BDT 2019
     */
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Jun 20 19:57:23 BDT 2019
     */
    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Jun 20 19:57:23 BDT 2019
     */
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Jun 20 19:57:23 BDT 2019
     */
    @Insert({
        "insert into user (email, password, ",
        "firstName, lastName, ",
        "permanentAddress, tempAddress, ",
        "birth_date, join_date)",
        "values (#{email,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{firstname,jdbcType=VARCHAR}, #{lastname,jdbcType=VARCHAR}, ",
        "#{permanentaddress,jdbcType=VARCHAR}, #{tempaddress,jdbcType=VARCHAR}, ",
        "#{birthDate,jdbcType=DATE}, #{joinDate,jdbcType=DATE})"
    })
    @SelectKey(statement="select currval('user_id_seq')", keyProperty="id", before=false, resultType=Integer.class)
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Jun 20 19:57:23 BDT 2019
     */
    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select currval('user_id_seq')", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Jun 20 19:57:23 BDT 2019
     */
    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="firstName", property="firstname", jdbcType=JdbcType.VARCHAR),
        @Result(column="lastName", property="lastname", jdbcType=JdbcType.VARCHAR),
        @Result(column="permanentAddress", property="permanentaddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="tempAddress", property="tempaddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="birth_date", property="birthDate", jdbcType=JdbcType.DATE),
        @Result(column="join_date", property="joinDate", jdbcType=JdbcType.DATE)
    })
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Jun 20 19:57:23 BDT 2019
     */
    @Select({
        "select",
        "id, email, password, firstName, lastName, permanentAddress, tempAddress, birth_date, ",
        "join_date",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="firstName", property="firstname", jdbcType=JdbcType.VARCHAR),
        @Result(column="lastName", property="lastname", jdbcType=JdbcType.VARCHAR),
        @Result(column="permanentAddress", property="permanentaddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="tempAddress", property="tempaddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="birth_date", property="birthDate", jdbcType=JdbcType.DATE),
        @Result(column="join_date", property="joinDate", jdbcType=JdbcType.DATE)
    })
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Jun 20 19:57:23 BDT 2019
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Jun 20 19:57:23 BDT 2019
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Jun 20 19:57:23 BDT 2019
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Jun 20 19:57:23 BDT 2019
     */
    @Update({
        "update user",
        "set email = #{email,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "firstName = #{firstname,jdbcType=VARCHAR},",
          "lastName = #{lastname,jdbcType=VARCHAR},",
          "permanentAddress = #{permanentaddress,jdbcType=VARCHAR},",
          "tempAddress = #{tempaddress,jdbcType=VARCHAR},",
          "birth_date = #{birthDate,jdbcType=DATE},",
          "join_date = #{joinDate,jdbcType=DATE}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}