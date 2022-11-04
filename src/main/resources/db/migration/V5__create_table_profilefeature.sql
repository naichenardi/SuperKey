create table profile_feature
(
    fk_profileId bigint,
    fk_featureId bigint,
    constraint PK_PROFILE_FEATURE primary key (fk_featureId, fk_profileId)
)