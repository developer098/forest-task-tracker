/**
 * This view is an example list of people.
 */
Ext.define('ForestTaskTracker.view.main.List', {
    extend: 'Ext.grid.Grid',
    xtype: 'mainlist',

    requires: [
        'ForestTaskTracker.store.ForestTasks'
    ],

    title: 'Tasks',

    store: {
        type: 'foresttasks'
    },

    columns: [
        { text: 'ID',  dataIndex: 'id', width: 100 },
        { text: 'Description', dataIndex: 'description', width: 230 }
    ],

    listeners: {
        select: 'onItemSelected'
    }
});
