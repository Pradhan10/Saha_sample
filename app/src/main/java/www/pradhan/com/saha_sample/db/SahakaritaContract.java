package www.pradhan.com.saha_sample.db;

import android.provider.BaseColumns;

public class SahakaritaContract {

    public static final class AgentEntry implements BaseColumns {
        public static final String TABLE_NAME = "collection";
        public static final String COLUMN_AGENTID = "agentId";
        public static final String COLUMN_AGENTNAME = "agentName";
        public static final String COLUMN_COLLECTIONAMT = "colectionAmount";
        public static final String COLUMN_DATE = "collectionDate";


    }

}
