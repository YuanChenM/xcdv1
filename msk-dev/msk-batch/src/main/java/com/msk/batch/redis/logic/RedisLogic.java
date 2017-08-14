package com.msk.batch.redis.logic;
/**
import com.msk.common.logic.CommonLogic;
import com.msk.common.logic.ConfigLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.CommConfig;
import com.msk.core.entity.CommConstant;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
**/
/**
 * *RedisLogic
 * *@author jiang_nan
 * *@version 1.0
 **/
//@Service
public class RedisLogic {
    /**Spring Redis Template
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private ConfigLogic configLogic;
    @Autowired
    private CommonLogic commonLogic;
    public void initConfig(){
        List<CommConfig> configList = configLogic.findList(new BaseParam());
        if (!CollectionUtils.isEmpty(configList)) {
            JedisConnectionFactory connectionFactory = (JedisConnectionFactory)this.redisTemplate.getConnectionFactory();
            connectionFactory.setDatabase(NumberConst.IntDef.INT_FOURTEEN);
            for (final CommConfig config : configList) {
                 redisTemplate.execute(new RedisCallback<Boolean>() {
                    public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                        RedisSerializer<String> serializer = getRedisSerializer();
                        byte[] byteKey  = serializer.serialize(config.getSystemKey());
                        byte[] byteValue = serializer.serialize(config.getSystemValue());
                        return connection.setNX(byteKey, byteValue);
                    }
                });
            }
        }

        List<CommConstant> constantList = commonLogic.findAll();
        if (!CollectionUtils.isEmpty(constantList)) {
            JedisConnectionFactory connectionFactory = (JedisConnectionFactory)this.redisTemplate.getConnectionFactory();
            connectionFactory.setDatabase(NumberConst.IntDef.INT_ZERO);
            Map<String,Map<String,String>> constantMap = new HashMap<String,Map<String,String>>();
            for (final CommConstant constant : constantList) {
                String key = constant.getConstantType();
                Map<String,String> value = constantMap.get(key);
                if(org.springframework.util.CollectionUtils.isEmpty(value)){
                    value = new HashMap<String,String>();
                    constantMap.put(key,value);
                }
                value.put(constant.getConstantValue(),constant.getConstantName());
            }

            if(!org.springframework.util.CollectionUtils.isEmpty(constantMap)){
                for(final Map.Entry<String,Map<String,String>> entry : constantMap.entrySet()){
                    redisTemplate.execute(new RedisCallback<Void>() {
                        @Override
                        public Void doInRedis(RedisConnection redisConnection) throws DataAccessException {
                            String key =entry.getKey();
                            BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(key);
                            boundHashOperations.putAll(entry.getValue());
                            return null;
                        }
                    });
            }
        }
    }
    }*/

    /**
     * 获取 RedisSerializer
     
    protected RedisSerializer<String> getRedisSerializer() {
        return redisTemplate.getStringSerializer();
    }*/

}
