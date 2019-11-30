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
import spl.question.bank.database.model.Role;
import spl.question.bank.database.model.RoleExample;

public interface RoleMapper extends MapperMarker {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    @SelectProvider(type=RoleSqlProvider.class, method="countByExample")
    long countByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    @DeleteProvider(type=RoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    @Delete({
        "delete from role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    @Insert({
        "insert into role (name)",
        "values (#{name,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select currval('role_id_seq')", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    @InsertProvider(type=RoleSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select currval('role_id_seq')", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    @SelectProvider(type=RoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Role> selectByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    @Select({
        "select",
        "id, name",
        "from role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Role selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    @UpdateProvider(type=RoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    @UpdateProvider(type=RoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    @UpdateProvider(type=RoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    @Update({
        "update role",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Role record);
}