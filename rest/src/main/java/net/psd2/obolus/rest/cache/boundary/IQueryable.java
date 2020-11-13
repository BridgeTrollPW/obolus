package net.psd2.obolus.rest.cache.boundary;

public interface IQueryable<R extends IQueryResult, Q extends IQuery> {
    R query(Q query);
}
