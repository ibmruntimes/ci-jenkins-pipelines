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
        ],
        'x64MacIBM'      : [
                'openj9'
        ],
        'x64LinuxIBM'    : [
                'openj9'
        ],
        'x64WindowsIBM'  : [
                'openj9'
        ],
        'ppc64AixIBM'    : [
                'openj9'
        ],
        'ppc64leLinuxIBM': [
                'openj9'
        ],
        's390xLinuxIBM'  : [
                'openj9'
        ],
        'aarch64LinuxIBM': [
                'openj9'
        ],
        'aarch64MacIBM': [
                'openj9'
        ]
]

// Weekly 8:00 pm Mon~Thur
triggerSchedule_nightly = 'H 21 * * 1-4'
// 12:00 pm Sat
triggerSchedule_weekly = 'H 13 * * 6'

// scmReferences to use for weekly release build
weekly_release_scmReferences = [
        'hotspot'        : '',
        'openj9'         : '',
        'corretto'       : '',
        'dragonwell'     : ''
]

return this
