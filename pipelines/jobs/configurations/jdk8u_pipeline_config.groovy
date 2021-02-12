class Config8 {
  final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac        : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: [
                        hotspot : 'macos10.14',
                        corretto: 'build-macstadium-macos1010-1',
                        openj9  : 'ci.project.openj9 && hw.arch.x86 && sw.os.osx.10_14'
                ],
                cleanWorkspaceAfterBuild: true,
                test                 : 'default'
        ],

        x64MacXL      : [
                os                   : 'mac',
                arch                 : 'x64',
                additionalNodeLabels : 'macos10.14',
                test                 : 'default',
                additionalFileNameTag: "macosXL",
                configureArgs        : '--with-noncompressedrefs'
        ],

        x64Linux      : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                dockerImage         : 'adoptopenjdk/centos6_build_image',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile',
                        dragonwell: 'pipelines/build/dockerFiles/dragonwell.dockerfile'
                ],
                dockerNode          : 'sw.tool.docker && sw.config.uid1000',
                test                 : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-jitserver',
                        "dragonwell"  : '--enable-unlimited-crypto --with-jvm-variants=server  --with-zlib=system',
                ]
        ],

        x64Windows    : [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: [
                        hotspot : 'win2012',
                        corretto: 'win2012',
                        openj9  : 'ci.project.openj9 && hw.arch.x86 && sw.os.windows',
                        dragonwell: 'win2012'
                ],
                test                 : 'default'
        ],

        x64WindowsXL    : [
                os                   : 'windows',
                arch                 : 'x64',
                additionalNodeLabels : 'win2012',
                test                 : 'default',
                additionalFileNameTag: "windowsXL",
                configureArgs        : '--with-noncompressedrefs'
        ],

        x32Windows    : [
                os                  : 'windows',
                arch                : 'x86-32',
                additionalNodeLabels: [
                        hotspot : 'win2012',
                        corretto: 'win2012',
                        openj9  : 'ci.project.openj9 && hw.arch.x86 && sw.os.windows'
                ],
                buildArgs : [
                        hotspot : '--jvm-variant client,server'
                ],
                test                 : 'default'
        ],

        ppc64Aix      : [
                os  : 'aix',
                arch: 'ppc64',
                additionalNodeLabels: [
                        hotspot: 'xlc13&&aix710',
                        openj9:  'hw.arch.ppc64 && sw.os.aix.7_1'
                ],
                test                 : 'default',
                configureArgs: [
                    "openj9"        : '--disable-ccache'
                ],
                cleanWorkspaceAfterBuild: true
        ],

        s390xLinux    : [
                os  : 'linux',
                arch: 's390x',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                test                 : 'default'
        ],

        sparcv9Solaris: [
                os  : 'solaris',
                arch: 'sparcv9',
                test: false
        ],

        x64Solaris    : [
                os                  : 'solaris',
                arch                : 'x64',
                test                : false
        ],

        ppc64leLinux  : [
                os  : 'linux',
                arch: 'ppc64le',
                additionalNodeLabels : 'centos7',
                test                 : 'default',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : [
                        "openj9"      : '--enable-jitserver'
                ]
        ],

        arm32Linux    : [
                os  : 'linux',
                arch: 'arm',
                test: 'default'
        ],

        aarch64Linux  : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerFile: [
                        dragonwell: 'pipelines/build/dockerFiles/dragonwell_aarch64.dockerfile'
                ],
                dockerNode         : 'sw.tool.docker',
                additionalNodeLabels: [
                        openj9:  'hw.arch.aarch64 && sw.os.linux'
                ],
                test                : [
                        nightly: ['sanity.functional', 'sanity.openjdk']
                ],
                cleanWorkspaceAfterBuild: true,
                test                 : 'default'
        ],

        x64LinuxXL       : [
                os                   : 'linux',
                dockerImage          : 'adoptopenjdk/centos6_build_image',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                arch                 : 'x64',
                additionalFileNameTag: "linuxXL",
                configureArgs        : '--with-noncompressedrefs --enable-jitserver',
                test                 : 'default'
        ],
        s390xLinuxXL       : [
                os                   : 'linux',
                arch                 : 's390x',
                additionalFileNameTag: "linuxXL",
                test                 : 'default',
                configureArgs        : '--with-noncompressedrefs'
        ],
        ppc64leLinuxXL       : [
                os                   : 'linux',
                arch                 : 'ppc64le',
                additionalNodeLabels : 'centos7',
                additionalFileNameTag: "linuxXL",
                test                 : 'default',
                configureArgs        : '--with-noncompressedrefs --enable-jitserver'
        ],
  ]

}

Config8 config = new Config8()
return config.buildConfigurations
