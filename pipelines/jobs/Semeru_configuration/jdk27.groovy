targetConfigurations = [
        'x64Mac'      : [
                'openj9'
        ],
        'x64Linux'    : [
                'openj9'
        ],
        'x64Windows'  : [
                'openj9'
        ],
        'ppc64Aix'    : [
                'openj9'
        ],
        'ppc64leLinux': [
                'openj9'
        ],
        's390xLinux'  : [
                'openj9'
        ],
        'aarch64Linux': [
                'openj9'
        ],
        'aarch64Mac': [
                'openj9'
        ]
]

// Weekly 8:00 pm Mon~Thur
triggerSchedule_nightly = 'H H(18-23) * * 1-4'
// 12:00 pm Sat
triggerSchedule_weekly = 'H H(10-20) * * 6'

// scmReferences to use for weekly release build
weekly_release_scmReferences = [
        'hotspot'        : '',
        'openj9'         : '',
        'corretto'       : '',
        'dragonwell'     : ''
]

return this

// Made with Bob
