CREATE KEYSPACE mixedquantum WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'};
USE mixedquantum;

CREATE TABLE mixedquantum.messages (
    channel text,
    id timeuuid,
    message text,
    source text,
    PRIMARY KEY (channel, id)
) WITH CLUSTERING ORDER BY (id DESC);
