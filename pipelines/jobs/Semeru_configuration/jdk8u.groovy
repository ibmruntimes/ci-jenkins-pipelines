targetConfigurations = [
        'x64Mac'        : [
                'openj9'
        ],
        'x64Linux'      : [
                'openj9'
        ],
        'x32Windows'    : [
                'openj9'
        ],
        'x64Windows'    : [
                'openj9'
        ],
        'ppc64Aix'      : [
                'openj9'
        ],
        'ppc64leLinux'  : [
                'openj9'
        ],
        's390xLinux'    : [
                'openj9'
        ],
        'aarch64Linux'  : [
                'openj9'
        ]
]

// Weeknights at 10:30pm
triggerSchedule_nightly = 'H H(18-23) * * 1-4'
// H9:00am Sat
triggerSchedule_weekly = 'H H(10-20) * * 5'

// scmReferences to use for weekly release build
weekly_release_scmReferences=[
        'openj9'         : ''
]

return this
