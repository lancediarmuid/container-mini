package cn.noexception.container.factory.convert.converter;

import cn.hutool.core.lang.Assert;

import java.util.Set;

/**
 * GenericConverter
 *
 * @author 吕滔
 * @Date 2021/11/18 16:56
 */
public interface GenericConverter {

    Set<ConvertiblePair> getConvertibleTypes();

    Object convert(Object source, Class sourceType, Class targetType);


    final class ConvertiblePair {
        private final Class<?> sourceType;
        private final Class<?> targetType;


        public ConvertiblePair(Class<?> sourceType, Class<?> targetType) {
            Assert.notNull(sourceType, "来源类型不能为空。");
            Assert.notNull(targetType, "目标类型不能为空。");
            this.sourceType = sourceType;
            this.targetType = targetType;
        }

        public Class<?> getSourceType() {
            return sourceType;
        }

        public Class<?> getTargetType() {
            return targetType;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != ConvertiblePair.class) {
                return false;
            }
            ConvertiblePair other = (ConvertiblePair) obj;
            return this.sourceType.equals(other.sourceType) && this.targetType.equals(other.targetType);
        }

        @Override
        public int hashCode() {
            return this.sourceType.hashCode() * 31 + this.targetType.hashCode();
        }
    }

}
