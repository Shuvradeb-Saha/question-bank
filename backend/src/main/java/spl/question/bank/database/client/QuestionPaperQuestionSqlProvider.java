package spl.question.bank.database.client;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import spl.question.bank.database.model.QuestionPaperQuestion;
import spl.question.bank.database.model.QuestionPaperQuestionExample.Criteria;
import spl.question.bank.database.model.QuestionPaperQuestionExample.Criterion;
import spl.question.bank.database.model.QuestionPaperQuestionExample;

public class QuestionPaperQuestionSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_paper_question
     *
     * @mbg.generated Fri Sep 20 13:25:36 BDT 2019
     */
    public String countByExample(QuestionPaperQuestionExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("question_paper_question");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_paper_question
     *
     * @mbg.generated Fri Sep 20 13:25:36 BDT 2019
     */
    public String deleteByExample(QuestionPaperQuestionExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("question_paper_question");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_paper_question
     *
     * @mbg.generated Fri Sep 20 13:25:36 BDT 2019
     */
    public String insertSelective(QuestionPaperQuestion record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("question_paper_question");
        
        if (record.getQuestionPaperId() != null) {
            sql.VALUES("question_paper_id", "#{questionPaperId,jdbcType=INTEGER}");
        }
        
        if (record.getQuestionId() != null) {
            sql.VALUES("question_id", "#{questionId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_paper_question
     *
     * @mbg.generated Fri Sep 20 13:25:36 BDT 2019
     */
    public String selectByExample(QuestionPaperQuestionExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("question_paper_id");
        sql.SELECT("question_id");
        sql.FROM("question_paper_question");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_paper_question
     *
     * @mbg.generated Fri Sep 20 13:25:36 BDT 2019
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        QuestionPaperQuestion record = (QuestionPaperQuestion) parameter.get("record");
        QuestionPaperQuestionExample example = (QuestionPaperQuestionExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("question_paper_question");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getQuestionPaperId() != null) {
            sql.SET("question_paper_id = #{record.questionPaperId,jdbcType=INTEGER}");
        }
        
        if (record.getQuestionId() != null) {
            sql.SET("question_id = #{record.questionId,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_paper_question
     *
     * @mbg.generated Fri Sep 20 13:25:36 BDT 2019
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("question_paper_question");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("question_paper_id = #{record.questionPaperId,jdbcType=INTEGER}");
        sql.SET("question_id = #{record.questionId,jdbcType=INTEGER}");
        
        QuestionPaperQuestionExample example = (QuestionPaperQuestionExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_paper_question
     *
     * @mbg.generated Fri Sep 20 13:25:36 BDT 2019
     */
    public String updateByPrimaryKeySelective(QuestionPaperQuestion record) {
        SQL sql = new SQL();
        sql.UPDATE("question_paper_question");
        
        if (record.getQuestionPaperId() != null) {
            sql.SET("question_paper_id = #{questionPaperId,jdbcType=INTEGER}");
        }
        
        if (record.getQuestionId() != null) {
            sql.SET("question_id = #{questionId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_paper_question
     *
     * @mbg.generated Fri Sep 20 13:25:36 BDT 2019
     */
    protected void applyWhere(SQL sql, QuestionPaperQuestionExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}