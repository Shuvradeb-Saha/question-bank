package spl.question.bank.database.client;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import spl.question.bank.database.model.CQQuestion;
import spl.question.bank.database.model.CQQuestionExample.Criteria;
import spl.question.bank.database.model.CQQuestionExample.Criterion;
import spl.question.bank.database.model.CQQuestionExample;

public class CQQuestionSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cq_question
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    public String countByExample(CQQuestionExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("cq_question");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cq_question
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    public String deleteByExample(CQQuestionExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("cq_question");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cq_question
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    public String insertSelective(CQQuestion record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("cq_question");
        
        if (record.getStem() != null) {
            sql.VALUES("stem", "#{stem,jdbcType=VARCHAR}");
        }
        
        if (record.getKnowledgeBased() != null) {
            sql.VALUES("knowledge_based", "#{knowledgeBased,jdbcType=VARCHAR}");
        }
        
        if (record.getUnderstandingBased() != null) {
            sql.VALUES("understanding_based", "#{understandingBased,jdbcType=VARCHAR}");
        }
        
        if (record.getApplicationBased() != null) {
            sql.VALUES("application_based", "#{applicationBased,jdbcType=VARCHAR}");
        }
        
        if (record.getHigherAbility() != null) {
            sql.VALUES("higher_ability", "#{higherAbility,jdbcType=VARCHAR}");
        }
        
        if (record.getWeight() != null) {
            sql.VALUES("weight", "#{weight,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedBy() != null) {
            sql.VALUES("created_by", "#{createdBy,jdbcType=INTEGER}");
        }
        
        if (record.getSubjectId() != null) {
            sql.VALUES("subject_id", "#{subjectId,jdbcType=INTEGER}");
        }
        
        if (record.getChapterId() != null) {
            sql.VALUES("chapter_id", "#{chapterId,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedAt() != null) {
            sql.VALUES("created_at", "#{createdAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModeratedAt() != null) {
            sql.VALUES("moderated_at", "#{moderatedAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModeratedBy() != null) {
            sql.VALUES("moderated_by", "#{moderatedBy,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getDifficulty() != null) {
            sql.VALUES("difficulty", "#{difficulty,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cq_question
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    public String selectByExample(CQQuestionExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("stem");
        sql.SELECT("knowledge_based");
        sql.SELECT("understanding_based");
        sql.SELECT("application_based");
        sql.SELECT("higher_ability");
        sql.SELECT("weight");
        sql.SELECT("created_by");
        sql.SELECT("subject_id");
        sql.SELECT("chapter_id");
        sql.SELECT("created_at");
        sql.SELECT("moderated_at");
        sql.SELECT("moderated_by");
        sql.SELECT("status");
        sql.SELECT("difficulty");
        sql.FROM("cq_question");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cq_question
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        CQQuestion record = (CQQuestion) parameter.get("record");
        CQQuestionExample example = (CQQuestionExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("cq_question");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getStem() != null) {
            sql.SET("stem = #{record.stem,jdbcType=VARCHAR}");
        }
        
        if (record.getKnowledgeBased() != null) {
            sql.SET("knowledge_based = #{record.knowledgeBased,jdbcType=VARCHAR}");
        }
        
        if (record.getUnderstandingBased() != null) {
            sql.SET("understanding_based = #{record.understandingBased,jdbcType=VARCHAR}");
        }
        
        if (record.getApplicationBased() != null) {
            sql.SET("application_based = #{record.applicationBased,jdbcType=VARCHAR}");
        }
        
        if (record.getHigherAbility() != null) {
            sql.SET("higher_ability = #{record.higherAbility,jdbcType=VARCHAR}");
        }
        
        if (record.getWeight() != null) {
            sql.SET("weight = #{record.weight,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedBy() != null) {
            sql.SET("created_by = #{record.createdBy,jdbcType=INTEGER}");
        }
        
        if (record.getSubjectId() != null) {
            sql.SET("subject_id = #{record.subjectId,jdbcType=INTEGER}");
        }
        
        if (record.getChapterId() != null) {
            sql.SET("chapter_id = #{record.chapterId,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedAt() != null) {
            sql.SET("created_at = #{record.createdAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModeratedAt() != null) {
            sql.SET("moderated_at = #{record.moderatedAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModeratedBy() != null) {
            sql.SET("moderated_by = #{record.moderatedBy,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getDifficulty() != null) {
            sql.SET("difficulty = #{record.difficulty,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cq_question
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("cq_question");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("stem = #{record.stem,jdbcType=VARCHAR}");
        sql.SET("knowledge_based = #{record.knowledgeBased,jdbcType=VARCHAR}");
        sql.SET("understanding_based = #{record.understandingBased,jdbcType=VARCHAR}");
        sql.SET("application_based = #{record.applicationBased,jdbcType=VARCHAR}");
        sql.SET("higher_ability = #{record.higherAbility,jdbcType=VARCHAR}");
        sql.SET("weight = #{record.weight,jdbcType=INTEGER}");
        sql.SET("created_by = #{record.createdBy,jdbcType=INTEGER}");
        sql.SET("subject_id = #{record.subjectId,jdbcType=INTEGER}");
        sql.SET("chapter_id = #{record.chapterId,jdbcType=INTEGER}");
        sql.SET("created_at = #{record.createdAt,jdbcType=TIMESTAMP}");
        sql.SET("moderated_at = #{record.moderatedAt,jdbcType=TIMESTAMP}");
        sql.SET("moderated_by = #{record.moderatedBy,jdbcType=INTEGER}");
        sql.SET("status = #{record.status,jdbcType=VARCHAR}");
        sql.SET("difficulty = #{record.difficulty,jdbcType=VARCHAR}");
        
        CQQuestionExample example = (CQQuestionExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cq_question
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    public String updateByPrimaryKeySelective(CQQuestion record) {
        SQL sql = new SQL();
        sql.UPDATE("cq_question");
        
        if (record.getStem() != null) {
            sql.SET("stem = #{stem,jdbcType=VARCHAR}");
        }
        
        if (record.getKnowledgeBased() != null) {
            sql.SET("knowledge_based = #{knowledgeBased,jdbcType=VARCHAR}");
        }
        
        if (record.getUnderstandingBased() != null) {
            sql.SET("understanding_based = #{understandingBased,jdbcType=VARCHAR}");
        }
        
        if (record.getApplicationBased() != null) {
            sql.SET("application_based = #{applicationBased,jdbcType=VARCHAR}");
        }
        
        if (record.getHigherAbility() != null) {
            sql.SET("higher_ability = #{higherAbility,jdbcType=VARCHAR}");
        }
        
        if (record.getWeight() != null) {
            sql.SET("weight = #{weight,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedBy() != null) {
            sql.SET("created_by = #{createdBy,jdbcType=INTEGER}");
        }
        
        if (record.getSubjectId() != null) {
            sql.SET("subject_id = #{subjectId,jdbcType=INTEGER}");
        }
        
        if (record.getChapterId() != null) {
            sql.SET("chapter_id = #{chapterId,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedAt() != null) {
            sql.SET("created_at = #{createdAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModeratedAt() != null) {
            sql.SET("moderated_at = #{moderatedAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModeratedBy() != null) {
            sql.SET("moderated_by = #{moderatedBy,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getDifficulty() != null) {
            sql.SET("difficulty = #{difficulty,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cq_question
     *
     * @mbg.generated Sat Nov 30 21:02:28 BDT 2019
     */
    protected void applyWhere(SQL sql, CQQuestionExample example, boolean includeExamplePhrase) {
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