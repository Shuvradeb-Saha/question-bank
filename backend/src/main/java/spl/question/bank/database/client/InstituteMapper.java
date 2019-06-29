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
import spl.question.bank.database.model.Institute;
import spl.question.bank.database.model.InstituteExample;

public interface InstituteMapper extends MapperMarker {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table institute
     *
     * @mbg.generated Sat Jun 29 10:41:05 BDT 2019
     */
    @SelectProvider(type=InstituteSqlProvider.class, method="countByExample")
    long countByExample(InstituteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table institute
     *
     * @mbg.generated Sat Jun 29 10:41:05 BDT 2019
     */
    @DeleteProvider(type=InstituteSqlProvider.class, method="deleteByExample")
    int deleteByExample(InstituteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table institute
     *
     * @mbg.generated Sat Jun 29 10:41:05 BDT 2019
     */
    @Delete({
        "delete from institute",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table institute
     *
     * @mbg.generated Sat Jun 29 10:41:05 BDT 2019
     */
    @Insert({
        "insert into institute (name, eiin_number)",
        "values (#{name,jdbcType=VARCHAR}, #{eiinNumber,jdbcType=INTEGER})"
    })
    @SelectKey(statement="select currval('institute_id_seq')", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Institute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table institute
     *
     * @mbg.generated Sat Jun 29 10:41:05 BDT 2019
     */
    @InsertProvider(type=InstituteSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select currval('institute_id_seq')", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Institute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table institute
     *
     * @mbg.generated Sat Jun 29 10:41:05 BDT 2019
     */
    @SelectProvider(type=InstituteSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="eiin_number", property="eiinNumber", jdbcType=JdbcType.INTEGER)
    })
    List<Institute> selectByExample(InstituteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table institute
     *
     * @mbg.generated Sat Jun 29 10:41:05 BDT 2019
     */
    @Select({
        "select",
        "id, name, eiin_number",
        "from institute",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="eiin_number", property="eiinNumber", jdbcType=JdbcType.INTEGER)
    })
    Institute selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table institute
     *
     * @mbg.generated Sat Jun 29 10:41:05 BDT 2019
     */
    @UpdateProvider(type=InstituteSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Institute record, @Param("example") InstituteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table institute
     *
     * @mbg.generated Sat Jun 29 10:41:05 BDT 2019
     */
    @UpdateProvider(type=InstituteSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Institute record, @Param("example") InstituteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table institute
     *
     * @mbg.generated Sat Jun 29 10:41:05 BDT 2019
     */
    @UpdateProvider(type=InstituteSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Institute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table institute
     *
     * @mbg.generated Sat Jun 29 10:41:05 BDT 2019
     */
    @Update({
        "update institute",
        "set name = #{name,jdbcType=VARCHAR},",
          "eiin_number = #{eiinNumber,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Institute record);
}