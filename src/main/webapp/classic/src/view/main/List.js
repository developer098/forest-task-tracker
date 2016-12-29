/**
 * This view is an example list of people.
 */
Ext.define('ForestTaskTracker.view.main.List', {
    extend: 'Ext.grid.Panel',
    xtype: 'mainlist',
    requires: [
        'ForestTaskTracker.store.ForestTasks'
    ],
    title: 'Tasks',
    store: {
        type: 'foresttasks'
    },
    columns: [
        { text: 'ID',  dataIndex: 'id' },
        { text: 'Description', dataIndex: 'description', flex: 1 }
    ],
    listeners: {
        select: 'onItemSelected'
    }
});
